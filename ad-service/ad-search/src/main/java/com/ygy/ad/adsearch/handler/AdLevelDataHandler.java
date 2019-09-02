package com.ygy.ad.adsearch.handler;

import com.alibaba.fastjson.JSON;
import com.ygy.ad.adcommon.dump.table.*;
import com.ygy.ad.adsearch.index.DataTable;
import com.ygy.ad.adsearch.index.IndexAware;
import com.ygy.ad.adsearch.index.adplan.AdPlanIndex;
import com.ygy.ad.adsearch.index.adplan.AdPlanObject;
import com.ygy.ad.adsearch.index.adunit.AdUnitIndex;
import com.ygy.ad.adsearch.index.adunit.AdUnitObject;
import com.ygy.ad.adsearch.index.creative.CreativeIndex;
import com.ygy.ad.adsearch.index.creative.CreativeObject;
import com.ygy.ad.adsearch.index.creativeunit.CreativeUnitIndex;
import com.ygy.ad.adsearch.index.creativeunit.CreativeUnitObject;
import com.ygy.ad.adsearch.index.district.UnitDistrictIndex;
import com.ygy.ad.adsearch.index.interest.UnitItIndex;
import com.ygy.ad.adsearch.index.keyword.UnitKeywordIndex;
import com.ygy.ad.adsearch.mysql.constant.OpType;
import com.ygy.ad.adsearch.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 1.索引之间存在着层级的划分，也就是依赖关系的划分
 * 2.加载全量索引其实是增量索引添加的一种特殊实现
 */
@Slf4j
public class AdLevelDataHandler {

    private static Logger logger= LoggerFactory.getLogger(AdLevelDataHandler.class);

    public static void handleLevel2(AdPlanTable planTable,OpType type){

        AdPlanObject planObject=new AdPlanObject(
                planTable.getId(),
                planTable.getUserId(),
                planTable.getPlanStatus(),
                planTable.getStartDate(),
                planTable.getEndDate()
        );
        handleBinlogEvent(DataTable.of(AdPlanIndex.class),
                planObject.getPlanId(),
                planObject,
                type);
    }

    public static void handleLevel2(AdCreativeTable creativeTable,OpType type){

        CreativeObject creativeObject=new CreativeObject(
                creativeTable.getAdId(),
                creativeTable.getName(),
                creativeTable.getType(),
                creativeTable.getMaterialType(),
                creativeTable.getHeight(),
                creativeTable.getWidth(),
                creativeTable.getAuditStatus(),
                creativeTable.getAdUrl()
        );

        handleBinlogEvent(DataTable.of(CreativeIndex.class),
                creativeObject.getAdId(),
                creativeObject,
                type);
    }

    public static void handleLevel3(AdUnitTable unitTable,OpType type){

        AdPlanObject adPlanObject=DataTable.of(AdPlanIndex.class).get(unitTable.getPlanId());
        if(null==adPlanObject){
            logger.error("handleLevel3 found AdPlanObject error:{}",unitTable.getPlanId());
            return;
        }

        AdUnitObject unitObject=new AdUnitObject(
                unitTable.getUnitId(),
                unitTable.getUnitStatus(),
                unitTable.getPositionType(),
                unitTable.getPlanId(),
                adPlanObject
        );

        handleBinlogEvent(DataTable.of(AdUnitIndex.class),
                unitObject.getUnitId(),
                unitObject,
                type);
    }

    public static void handleLevel3(AdCreativeUnitTable creativeUnitTable,OpType type){

        if(type==OpType.UPDATA){
            logger.error("CreativeUnitIndex not support update");
            return;
        }

        AdUnitObject unitObject=DataTable.of(AdUnitIndex.class).get(creativeUnitTable.getUnitId());
        CreativeObject creativeObject=DataTable.of(CreativeIndex.class).get(creativeUnitTable.getAdId());
        if(null==unitObject || null==creativeObject){
            logger.error("AdCreativeUnitTable index error:{}", JSON.toJSONString(creativeUnitTable));
            return;
        }

        CreativeUnitObject creativeUnitObject=new CreativeUnitObject(
                creativeUnitTable.getAdId(),
                creativeUnitTable.getUnitId()
        );
        handleBinlogEvent(
                DataTable.of(CreativeUnitIndex.class),
                CommonUtils.stringConcat(
                        creativeUnitObject.getAdId().toString(),
                        creativeUnitObject.getUnitId().toString()
                ),
                creativeUnitObject,
                type
        );
    }

    public static void handleLevel4(AdUnitDistrictTable unitDistrictTable,OpType type){

        if (type == OpType.UPDATA) {
            logger.error("district index can not support update");
            return;
        }

        AdUnitObject unitObject = DataTable.of(AdUnitIndex.class).get(unitDistrictTable.getUnitId());
        if (unitObject == null) {
            logger.error("AdUnitDistrictTable index error: {}", unitDistrictTable.getUnitId());
            return;
        }

        String key = CommonUtils.stringConcat(
                unitDistrictTable.getProvince(),
                unitDistrictTable.getCity()
        );
        Set<Long> value = new HashSet<>(Collections.singleton(unitDistrictTable.getUnitId()));
        handleBinlogEvent(
                DataTable.of(UnitDistrictIndex.class),
                key, value,
                type
        );
    }

    public static void handleLevel4(AdUnitItTable unitItTable, OpType type) {

        if (type == OpType.UPDATA) {
            logger.error("it index can not support update");
            return;
        }

        AdUnitObject unitObject = DataTable.of(AdUnitIndex.class).get(unitItTable.getUnitId());
        if (unitObject == null) {
            logger.error("AdUnitItTable index error: {}", unitItTable.getUnitId());
            return;
        }

        Set<Long> value = new HashSet<>(Collections.singleton(unitItTable.getUnitId()));
        handleBinlogEvent(
                DataTable.of(UnitItIndex.class),
                unitItTable.getItTag(),
                value,
                type
        );
    }

    public static void handleLevel4(AdUnitKeywordTable keywordTable, OpType type) {

        if (type == OpType.UPDATA) {
            logger.error("keyword index can not support update");
            return;
        }

        AdUnitObject unitObject = DataTable.of(AdUnitIndex.class).get(keywordTable.getUnitId());
        if (unitObject == null) {
            logger.error("AdUnitKeywordTable index error: {}", keywordTable.getUnitId());
            return;
        }

        Set<Long> value = new HashSet<>(Collections.singleton(keywordTable.getUnitId()));
        handleBinlogEvent(
                DataTable.of(UnitKeywordIndex.class),
                keywordTable.getKeyword(),
                value,
                type
        );
    }

    private static <K,V> void handleBinlogEvent(IndexAware<K,V> index, K key, V value, OpType type){

        switch (type){
            case ADD:
                index.add(key,value);
                break;
            case UPDATA:
                index.update(key, value);
                break;
            case DELETE:
                index.delete(key, value);
                break;
            default:
                    break;
        }
    }
}
