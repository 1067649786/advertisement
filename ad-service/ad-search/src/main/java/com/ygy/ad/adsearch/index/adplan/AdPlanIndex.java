package com.ygy.ad.adsearch.index.adplan;

import com.ygy.ad.adsearch.controller.SearchController;
import com.ygy.ad.adsearch.index.IndexAware;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class AdPlanIndex implements IndexAware<Long,AdPlanObject> {

    private Logger logger= LoggerFactory.getLogger(AdPlanIndex.class);

    private static Map<Long,AdPlanObject> objectMap;

    static {
        objectMap=new ConcurrentHashMap<>();
    }

    @Override
    public AdPlanObject get(Long key) {
        return objectMap.get(key);
    }

    @Override
    public void add(Long key, AdPlanObject value) {

        logger.info("before add: {}",objectMap);
        objectMap.put(key,value);
        logger.info("after add:{}",objectMap);
    }

    @Override
    public void update(Long key, AdPlanObject value) {

        logger.info("before update: {}",objectMap);
        AdPlanObject oldObject=objectMap.get(key);
        if(null == oldObject){
            objectMap.put(key, value);
        }else{
            oldObject.update(value);
        }

        logger.info("after update: {}",objectMap);
    }

    @Override
    public void delete(Long key, AdPlanObject value) {

        logger.info("before delete: {}",objectMap);
        objectMap.remove(key);
        logger.info("after delete: {}",objectMap);
    }
}
