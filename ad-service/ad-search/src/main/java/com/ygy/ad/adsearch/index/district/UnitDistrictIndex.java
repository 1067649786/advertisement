package com.ygy.ad.adsearch.index.district;

import com.ygy.ad.adsearch.index.IndexAware;
import com.ygy.ad.adsearch.index.adunit.AdUnitIndex;
import com.ygy.ad.adsearch.search.vo.feature.DistrictFeature;
import com.ygy.ad.adsearch.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

@Slf4j
@Component
public class UnitDistrictIndex implements IndexAware<String, Set<Long>> {

    private Logger logger= LoggerFactory.getLogger(UnitDistrictIndex.class);

    private static Map<String, Set<Long>> districtUnitMap;
    private static Map<Long, Set<String>> unitDistrictMap;

    static {
        districtUnitMap = new ConcurrentHashMap<>();
        unitDistrictMap = new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {
        return districtUnitMap.get(key);
    }

    @Override
    public void add(String key, Set<Long> value) {

        logger.info("UnitDistrictIndex, before add: {}", unitDistrictMap);

        Set<Long> unitIds = CommonUtils.getrorCreate(
                key, districtUnitMap,
                ConcurrentSkipListSet::new
        );
        unitIds.addAll(value);

        for (Long unitId : value) {

            Set<String> districts = CommonUtils.getrorCreate(
                    unitId, unitDistrictMap,
                    ConcurrentSkipListSet::new
            );
            districts.add(key);
        }

        logger.info("UnitDistrictIndex, after add: {}", unitDistrictMap);
    }

    @Override
    public void update(String key, Set<Long> value) {

        logger.error("district index can not support update");
    }

    @Override
    public void delete(String key, Set<Long> value) {

        logger.info("UnitDistrictIndex, before delete: {}", unitDistrictMap);

        Set<Long> unitIds = CommonUtils.getrorCreate(
                key, districtUnitMap,
                ConcurrentSkipListSet::new
        );
        unitIds.removeAll(value);

        for (Long unitId : value) {

            Set<String> districts = CommonUtils.getrorCreate(
                    unitId, unitDistrictMap,
                    ConcurrentSkipListSet::new
            );
            districts.remove(key);
        }

        logger.info("UnitDistrictIndex, after delete: {}", unitDistrictMap);
    }

    public boolean match(Long adUnitId, List<DistrictFeature.ProvinceAndCity> districts){

        if (unitDistrictMap.containsKey(adUnitId) && CollectionUtils.isNotEmpty(unitDistrictMap.get(adUnitId))){

            Set<String> unitDistricts=unitDistrictMap.get(adUnitId);
            List<String> targetDistricts=districts.stream()
                    .map(
                            d -> CommonUtils.stringConcat(d.getProvince(),d.getCity())
                    ).collect(Collectors.toList());

            return CollectionUtils.isSubCollection(targetDistricts,unitDistricts);
        }
        return false;
    }
}
