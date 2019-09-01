package com.ygy.ad.adsponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdUnitKeywordRequest {

    private List<UnitKeyword> unitKeywords;

    public AdUnitKeywordRequest(List<UnitKeyword> unitKeywords) {
        this.unitKeywords = unitKeywords;
    }

    public List<UnitKeyword> getUnitKeywords() {
        return unitKeywords;
    }

    public void setUnitKeywords(List<UnitKeyword> unitKeywords) {
        this.unitKeywords = unitKeywords;
    }

    @Data
    @NoArgsConstructor
    public static class UnitKeyword{

        private Long unitId;
        private String keyword;

        public UnitKeyword(Long unitId, String keyword) {
            this.unitId = unitId;
            this.keyword = keyword;
        }

        public Long getUnitId() {
            return unitId;
        }

        public void setUnitId(Long unitId) {
            this.unitId = unitId;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }
    }
}
