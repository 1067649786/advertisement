package com.ygy.ad.adsearch.search.vo;

import com.ygy.ad.adsearch.index.creative.CreativeObject;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class SearchReponse {

    public Map<String,List<Creative>> adSlot2Ads=new HashMap<>();

    public SearchReponse(Map<String, List<Creative>> adSlot2Ads) {
        this.adSlot2Ads = adSlot2Ads;
    }

    public SearchReponse(){}

    public Map<String, List<Creative>> getAdSlot2Ads() {
        return adSlot2Ads;
    }

    public void setAdSlot2Ads(Map<String, List<Creative>> adSlot2Ads) {
        this.adSlot2Ads = adSlot2Ads;
    }

    public static Creative convert(CreativeObject object){

        Creative creative=new Creative();
        creative.setAdId(object.getAdId());
        creative.setAdUrl(object.getAdUrl());
        creative.setWidth(object.getWidth());
        creative.setHeight(object.getHeight());
        creative.setType(object.getType());
        creative.setMaterialType(object.getMaterialType());

        return creative;

    }

    public static class Creative{

        private Long adId;
        private String adUrl;
        private Integer width;
        private Integer height;
        private Integer type;
        private Integer materialType;

        //展示检测url
        private List<String> showMonitorUrl= Arrays.asList("www.imooc.com","www.imooc.com");
        //点击检测url
        private List<String> clickMonitorUrl=Arrays.asList("www.imooc.com","www.imooc.com");

        public Creative(Long adId, String adUrl, Integer width, Integer height, Integer type, Integer materialType, List<String> showMonitorUrl, List<String> clickMonitorUrl) {
            this.adId = adId;
            this.adUrl = adUrl;
            this.width = width;
            this.height = height;
            this.type = type;
            this.materialType = materialType;
            this.showMonitorUrl = showMonitorUrl;
            this.clickMonitorUrl = clickMonitorUrl;
        }

        public Creative(){}

        public Long getAdId() {
            return adId;
        }

        public void setAdId(Long adId) {
            this.adId = adId;
        }

        public String getAdUrl() {
            return adUrl;
        }

        public void setAdUrl(String adUrl) {
            this.adUrl = adUrl;
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

        public List<String> getShowMonitorUrl() {
            return showMonitorUrl;
        }

        public void setShowMonitorUrl(List<String> showMonitorUrl) {
            this.showMonitorUrl = showMonitorUrl;
        }

        public List<String> getClickMonitorUrl() {
            return clickMonitorUrl;
        }

        public void setClickMonitorUrl(List<String> clickMonitorUrl) {
            this.clickMonitorUrl = clickMonitorUrl;
        }
    }
}
