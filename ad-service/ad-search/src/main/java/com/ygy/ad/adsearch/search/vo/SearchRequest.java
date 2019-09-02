package com.ygy.ad.adsearch.search.vo;

import com.ygy.ad.adsearch.search.vo.feature.DistrictFeature;
import com.ygy.ad.adsearch.search.vo.feature.FeatureRelation;
import com.ygy.ad.adsearch.search.vo.feature.ItFeature;
import com.ygy.ad.adsearch.search.vo.feature.KeywordFeature;
import com.ygy.ad.adsearch.search.vo.media.AdSlot;
import com.ygy.ad.adsearch.search.vo.media.App;
import com.ygy.ad.adsearch.search.vo.media.Device;
import com.ygy.ad.adsearch.search.vo.media.Geo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SearchRequest {

    //媒体方的请求标识
    private String mediaId;
    //请求基本信息
    private RequestInfo requestInfo;
    //匹配信息
    private FeatureInfo featureInfo;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public RequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    public FeatureInfo getFeatureInfo() {
        return featureInfo;
    }

    public void setFeatureInfo(FeatureInfo featureInfo) {
        this.featureInfo = featureInfo;
    }

    public static class RequestInfo{

        private String requestId;

        private List<AdSlot> adSlots;
        private App app;
        private Geo geo;
        private Device device;

        public RequestInfo(String requestId, List<AdSlot> adSlots, App app, Geo geo, Device device) {
            this.requestId = requestId;
            this.adSlots = adSlots;
            this.app = app;
            this.geo = geo;
            this.device = device;
        }

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public List<AdSlot> getAdSlots() {
            return adSlots;
        }

        public void setAdSlots(List<AdSlot> adSlots) {
            this.adSlots = adSlots;
        }

        public App getApp() {
            return app;
        }

        public void setApp(App app) {
            this.app = app;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        public Device getDevice() {
            return device;
        }

        public void setDevice(Device device) {
            this.device = device;
        }
    }

    public static class FeatureInfo{

        private KeywordFeature keywordFeature;
        private DistrictFeature districtFeature;
        private ItFeature itFeature;

        private FeatureRelation relation=FeatureRelation.AND;

        public FeatureInfo(KeywordFeature keywordFeature, DistrictFeature districtFeature, ItFeature itFeature, FeatureRelation relation) {
            this.keywordFeature = keywordFeature;
            this.districtFeature = districtFeature;
            this.itFeature = itFeature;
            this.relation = relation;
        }

        public KeywordFeature getKeywordFeature() {
            return keywordFeature;
        }

        public void setKeywordFeature(KeywordFeature keywordFeature) {
            this.keywordFeature = keywordFeature;
        }

        public DistrictFeature getDistrictFeature() {
            return districtFeature;
        }

        public void setDistrictFeature(DistrictFeature districtFeature) {
            this.districtFeature = districtFeature;
        }

        public ItFeature getItFeature() {
            return itFeature;
        }

        public void setItFeature(ItFeature itFeature) {
            this.itFeature = itFeature;
        }

        public FeatureRelation getRelation() {
            return relation;
        }

        public void setRelation(FeatureRelation relation) {
            this.relation = relation;
        }
    }
}
