package com.ygy.ad.adsearch.index.creative;

import com.ygy.ad.adsearch.index.IndexAware;
import com.ygy.ad.adsearch.index.adunit.AdUnitIndex;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class CreativeIndex implements IndexAware<Long,CreativeObject> {

    private Logger logger= LoggerFactory.getLogger(AdUnitIndex.class);

    private static Map<Long, CreativeObject> objectMap;

    static {
        objectMap = new ConcurrentHashMap<>();
    }

    @Override
    public CreativeObject get(Long key) {
        return objectMap.get(key);
    }

    @Override
    public void add(Long key, CreativeObject value) {

        logger.info("before add: {}", objectMap);
        objectMap.put(key, value);
        logger.info("after add: {}", objectMap);
    }

    @Override
    public void update(Long key, CreativeObject value) {

        logger.info("before update: {}", objectMap);

        CreativeObject oldObject = objectMap.get(key);
        if (null == oldObject) {
            objectMap.put(key, value);
        } else {
            oldObject.update(value);
        }

        logger.info("after update: {}", objectMap);
    }

    @Override
    public void delete(Long key, CreativeObject value) {

        logger.info("before delete: {}", objectMap);
        objectMap.remove(key);
        logger.info("after delete: {}", objectMap);
    }
}
