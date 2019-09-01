package com.ygy.ad.adsearch.index.adunit;

import com.ygy.ad.adsearch.index.adplan.AdPlanObject;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdUnitObject {

    private Long unitId;
    private Integer unitStatus;
    private Integer positionType;
    private Long planId;

    private AdPlanObject adPlanObject;

    void update(AdUnitObject newObject){

        if(null != newObject.getUnitId()){
            this.unitId=newObject.getUnitId();
        }
        if(null != newObject.getUnitStatus()){
            this.unitStatus=newObject.getUnitStatus();
        }
        if(null != newObject.getPositionType()){
            this.positionType=newObject.getPositionType();
        }
        if(null != newObject.getPlanId()){
            this.planId=newObject.getPlanId();
        }
        if(null != newObject.getAdPlanObject()){
            this.adPlanObject=newObject.getAdPlanObject();
        }
    }

    public AdUnitObject(Long unitId, Integer unitStatus, Integer positionType, Long planId, AdPlanObject adPlanObject) {
        this.unitId = unitId;
        this.unitStatus = unitStatus;
        this.positionType = positionType;
        this.planId = planId;
        this.adPlanObject = adPlanObject;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Integer getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(Integer unitStatus) {
        this.unitStatus = unitStatus;
    }

    public Integer getPositionType() {
        return positionType;
    }

    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public AdPlanObject getAdPlanObject() {
        return adPlanObject;
    }

    public void setAdPlanObject(AdPlanObject adPlanObject) {
        this.adPlanObject = adPlanObject;
    }
}
