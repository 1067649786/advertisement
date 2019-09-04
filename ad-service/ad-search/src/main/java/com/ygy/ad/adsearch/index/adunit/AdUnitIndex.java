package com.ygy.ad.adsearch.index.adunit;

import com.ygy.ad.adsearch.index.IndexAware;
import com.ygy.ad.adsearch.index.adplan.AdPlanIndex;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class AdUnitIndex implements IndexAware<Long,AdUnitObject> {

    private Logger logger= LoggerFactory.getLogger(AdUnitIndex.class);

    private static Map<Long,AdUnitObject> objectMap;

    static {
        objectMap=new ConcurrentHashMap<>();
    }

    public Set<Long> match(Integer positionType){

        Set<Long> adUnitIds=new HashSet<>();

        objectMap.forEach((k,v) -> {
            if (AdUnitObject.isAdSlotTypeOK(positionType,v.getPositionType())){
                adUnitIds.add(k);
            }
        });
        return adUnitIds;
    }

    public List<AdUnitObject> fetch(Collection<Long> adUnitIds){

        if(CollectionUtils.isEmpty(adUnitIds)){
            return Collections.emptyList();
        }

        List<AdUnitObject> result=new ArrayList<>();

        adUnitIds.forEach(u -> {
            AdUnitObject object=get(u);
            if(object==null){
                logger.error("AdUnitObject not found: {}",u);
                return;
            }
            result.add(object);
        });

        return result;
    }

    @Override
    public AdUnitObject get(Long key) {
        return objectMap.get(key);
    }

    @Override
    public void add(Long key, AdUnitObject value) {

        logger.info("before add: {}",objectMap);
        objectMap.put(key,value);
        logger.info("after add: {}",objectMap);

    }

    @Override
    public void update(Long key, AdUnitObject value) {

        logger.info("before update: {}",objectMap);

        AdUnitObject oldObject=objectMap.get(key);
        if(null == oldObject){
            objectMap.put(key,value);
        }else {
            oldObject.update(value);
        }

        logger.info("after update: {}",objectMap);

    }

    @Override
    public void delete(Long key, AdUnitObject value) {

        logger.info("before delete: {}",objectMap);
        objectMap.remove(key);
        logger.info("after delete: {}",objectMap);

    }
}
