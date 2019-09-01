package com.ygy.ad.adsponsor.entity;


import com.ygy.ad.adsponsor.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_unit")
public class AdUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic
    @Column(name = "plan_id",nullable = false)
    private Long planId;

    @Basic
    @Column(name = "unit_name",nullable = false)
    private String unitName;

    @Basic
    @Column(name = "unit_status",nullable = false)
    private Integer unitStatus;

    //广告位类型（开屏、贴片、中贴...）
    @Basic
    @Column(name = "position_type",nullable = false)
    private Integer positonType;

    @Basic
    @Column(name = "budget",nullable = false)
    private Long budget;

    @Basic
    @Column(name = "create_time",nullable = false)
    private Date createTime;

    @Basic
    @Column(name = "update_time",nullable = false)
    private Date updateTime;

    public AdUnit(Long planId,String unitName,Integer positonType,Long budget){
        this.planId=planId;
        this.unitName=unitName;
        this.unitStatus= CommonStatus.VALID.getStatus();
        this.positonType=positonType;
        this.budget=budget;
        this.createTime=new Date();
        this.updateTime=this.createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(Integer unitStatus) {
        this.unitStatus = unitStatus;
    }

    public Integer getPositonType() {
        return positonType;
    }

    public void setPositonType(Integer positonType) {
        this.positonType = positonType;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
