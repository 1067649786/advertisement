package com.ygy.ad.adsearch.index.keyword;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnitKeywordObject {

    private Long unitId;
    private String keyword;

    public UnitKeywordObject(Long unitId, String keyword) {
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
