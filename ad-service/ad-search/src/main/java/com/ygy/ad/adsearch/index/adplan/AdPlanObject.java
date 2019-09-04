package com.ygy.ad.adsearch.index.adplan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class AdPlanObject {

    private Long planId;
    private Long userId;
    private Integer planStatus;
    private Date startDate;
    private Date endDate;

    public void update(AdPlanObject newObject){

        if(null != newObject.getPlanId())
            this.planId=newObject.getPlanId();
        if(null != newObject.getUserId())
            this.userId=newObject.getUserId();
        if(null != newObject.getPlanStatus())
            this.planStatus=newObject.getPlanStatus();
        if(null != newObject.getStartDate())
            this.startDate=newObject.getStartDate();
        if(null != newObject.getEndDate())
            this.endDate=newObject.getEndDate();
    }

    public AdPlanObject(Long planId, Long userId, Integer planStatus, Date startDate, Date endDate) {
        this.planId = planId;
        this.userId = userId;
        this.planStatus = planStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Integer planStatus) {
        this.planStatus = planStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
