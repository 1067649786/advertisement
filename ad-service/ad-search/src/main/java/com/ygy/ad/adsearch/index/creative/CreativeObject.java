package com.ygy.ad.adsearch.index.creative;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreativeObject {

    private Long adId;
    private String name;
    private Integer type;
    private Integer materialType;
    private Integer height;
    private Integer width;
    private Integer auditStatus;
    private String adUrl;

    public void update(CreativeObject newObject) {

        if (null != newObject.getAdId()) {
            this.adId = newObject.getAdId();
        }
        if (null != newObject.getName()) {
            this.name = newObject.getName();
        }
        if (null != newObject.getType()) {
            this.type = newObject.getType();
        }
        if (null != newObject.getMaterialType()) {
            this.materialType = newObject.getMaterialType();
        }
        if (null != newObject.getHeight()) {
            this.height = newObject.getHeight();
        }
        if (null != newObject.getWidth()) {
            this.width = newObject.getWidth();
        }
        if (null != newObject.getAuditStatus()) {
            this.auditStatus = newObject.getAuditStatus();
        }
        if (null != newObject.getAdUrl()) {
            this.adUrl = newObject.getAdUrl();
        }
    }

    public CreativeObject(Long adId, String name, Integer type, Integer materialType, Integer height, Integer width, Integer auditStatus, String adUrl) {
        this.adId = adId;
        this.name = name;
        this.type = type;
        this.materialType = materialType;
        this.height = height;
        this.width = width;
        this.auditStatus = auditStatus;
        this.adUrl = adUrl;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Integer materialType) {
        this.materialType = materialType;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }
}
