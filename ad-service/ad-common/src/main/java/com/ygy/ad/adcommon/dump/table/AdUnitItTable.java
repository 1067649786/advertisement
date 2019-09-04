package com.ygy.ad.adcommon.dump.table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AdUnitItTable {

    private Long unitId;
    private String itTag;

    public AdUnitItTable(Long unitId, String itTag) {
        this.unitId = unitId;
        this.itTag = itTag;
    }

    public AdUnitItTable(){}

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
