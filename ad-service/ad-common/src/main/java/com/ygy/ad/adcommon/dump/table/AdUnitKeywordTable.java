package com.ygy.ad.adcommon.dump.table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AdUnitKeywordTable {

    private Long unitId;
    private String keyword;

    public AdUnitKeywordTable(Long unitId, String keyword) {
        this.unitId = unitId;
        this.keyword = keyword;
    }

    public AdUnitKeywordTable(){}

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
