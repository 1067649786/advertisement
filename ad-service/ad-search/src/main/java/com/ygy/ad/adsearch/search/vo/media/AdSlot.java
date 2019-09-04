package com.ygy.ad.adsearch.search.vo.media;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdSlot {

    //广告位编码
    private String adSlotCode;

    //流量类型
    private Integer positionType;

    //宽和高
    private Integer width;

    private Integer height;

    //广告物料类型：图片、视频
    private List<Integer> type;

    //最低出价
    private Integer minCpm;

    public AdSlot(String adSlotCode, Integer positionType, Integer width, Integer height, List<Integer> type, Integer minCpm) {
        this.adSlotCode = adSlotCode;
        this.positionType = positionType;
        this.width = width;
        this.height = height;
        this.type = type;
        this.minCpm = minCpm;
    }

    public String getAdSlotCode() {
        return adSlotCode;
    }

    public void setAdSlotCode(String adSlotCode) {
        this.adSlotCode = adSlotCode;
    }

    public Integer getPositionType() {
        return positionType;
    }

    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public List<Integer> getType() {
        return type;
    }

    public void setType(List<Integer> type) {
        this.type = type;
    }

    public Integer getMinCpm() {
        return minCpm;
    }

    public void setMinCpm(Integer minCpm) {
        this.minCpm = minCpm;
    }
}
