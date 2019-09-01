package com.ygy.ad.adsearch.index.interest;

import com.ygy.ad.adsearch.index.IndexAware;
import com.ygy.ad.adsearch.index.adunit.AdUnitIndex;
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

@Slf4j
@Component
public class UnitItIndex implements IndexAware<String, Set<Long>> {

    private Logger logger= LoggerFactory.getLogger(UnitItIndex.class);

    //<itTag,adUnitId set>
    private static Map<String,Set<Long>> itUnitMap;

    //<unitId,itTag set>
    private static Map<Long,Set<String>> unitItMap;

    static {
        itUnitMap=new ConcurrentHashMap<>();
        unitItMap=new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {
        return itUnitMap.get(key);
    }

    @Override
    public void add(String key, Set<Long> value) {

        logger.info("UnitItIndex,before add:{}",unitItMap);

        Set<Long> unitIds= CommonUtils.getrorCreate(key,itUnitMap, ConcurrentSkipListSet::new);
        unitIds.addAll(value);

        for (Long unitId:value){
            Set<String> its=CommonUtils.getrorCreate(unitId,unitItMap,ConcurrentSkipListSet::new);
            its.add(key);
        }

        logger.info("UnitItIndex,after add:{}",unitItMap);
    }

    @Override
    public void update(String key, Set<Long> value) {

        logger.error("it index can not support update");
    }

    @Override
    public void delete(String key, Set<Long> value) {

        logger.info("UnitItIndex,before delete:{}",unitItMap);

        Set<Long> unitIds=CommonUtils.getrorCreate(key,itUnitMap,ConcurrentSkipListSet::new);
        unitIds.removeAll(value);

        for (Long unitId:value){
            Set<String> itTagSet=CommonUtils.getrorCreate(unitId,unitItMap,ConcurrentSkipListSet::new);
            itTagSet.remove(key);
        }

        logger.info("UnitIndex,after delete:{}",unitItMap);
    }

    public boolean match(Long unitId, List<String> itTags){

        if(unitItMap.containsKey(unitId) && CollectionUtils.isNotEmpty(unitItMap.get(unitId))){

            Set<String> unitKeywords=unitItMap.get(unitId);
            return CollectionUtils.isSubCollection(itTags,unitKeywords);
        }

        return false;
    }
}
