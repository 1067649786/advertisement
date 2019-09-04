package com.ygy.ad.adsponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdUnitItRequest {

    private List<UnitIt> unitIts;

    public AdUnitItRequest(List<UnitIt> unitIts) {
        this.unitIts = unitIts;
    }

    public List<UnitIt> getUnitIts() {
        return unitIts;
    }

    public void setUnitIts(List<UnitIt> unitIts) {
        this.unitIts = unitIts;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitIt{

        private Long unitId;
        private String itTag;

        public Long getUnitId() {
            return unitId;
        }

        public void setUnitId(Long unitId) {
            this.unitId = unitId;
        }

        public String getItTag() {
            return itTag;
        }

        public void setItTag(String itTag) {
            this.itTag = itTag;
        }
    }
}
