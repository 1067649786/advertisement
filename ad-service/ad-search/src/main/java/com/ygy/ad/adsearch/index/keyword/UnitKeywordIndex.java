package com.ygy.ad.adsearch.index.keyword;

import com.ygy.ad.adsearch.index.IndexAware;
import com.ygy.ad.adsearch.index.adunit.AdUnitIndex;
import com.ygy.ad.adsearch.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

@Slf4j
@Component
public class UnitKeywordIndex implements IndexAware<String, Set<Long>> {

    private Logger logger= LoggerFactory.getLogger(UnitKeywordIndex.class);

    private static Map<String,Set<Long>> keywordUnitMap;
    private static Map<Long,Set<String>> unitKeywordMap;

    static {
        keywordUnitMap=new ConcurrentHashMap<>();
        unitKeywordMap=new ConcurrentHashMap<>();
    }

    @Override
    public Set<Long> get(String key) {

        if(StringUtils.isEmpty(key)){
            return Collections.emptySet();
        }

        Set<Long> result=keywordUnitMap.get(key);
        if(result==null){
            return Collections.emptySet();
        }

        return result;
    }

    @Override
    public void add(String key, Set<Long> value) {

        logger.info("UnitKeywordIndex,before add:{}",unitKeywordMap);

        Set<Long> unitIdSet= CommonUtils.getrorCreate(key,keywordUnitMap, ConcurrentSkipListSet::new);
        unitIdSet.addAll(value);

        for (Long unitId:value){
            Set<String> keywordSet=CommonUtils.getrorCreate(unitId,unitKeywordMap,ConcurrentSkipListSet::new);
            keywordSet.add(key);
        }

        logger.info("UnitKeywordIndex,after add:{}",unitKeywordMap);
    }

    @Override
    public void update(String key, Set<Long> value) {

        logger.error("keyword index can not support update");

    }

    @Override
    public void delete(String key, Set<Long> value) {

        logger.info("UnitKeywordIndex,before delete:{}",unitKeywordMap);

        Set<Long> unitIds=CommonUtils.getrorCreate(key,keywordUnitMap,ConcurrentSkipListSet::new);
        unitIds.removeAll(value);

        for (Long unitId:value){
            Set<String> keywordSet=CommonUtils.getrorCreate(unitId,unitKeywordMap,ConcurrentSkipListSet::new);
            keywordSet.remove(key);
        }

        logger.info("UnitKeywordIndex,after delete:{}",unitKeywordMap);
    }

    public boolean match(Long unitId, List<String> keywords){

        if(unitKeywordMap.containsKey(unitId) && CollectionUtils.isNotEmpty(unitKeywordMap.get(unitId))){

            Set<String> unitKeyword=unitKeywordMap.get(unitId);
            return CollectionUtils.isSubCollection(keywords,unitKeyword);
        }

        return false;
    }
}
