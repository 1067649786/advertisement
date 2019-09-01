package com.ygy.ad.adsearch.index.interest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UnitItObject {

    private Long unitId;
    private String itTag;

    public UnitItObject(Long unitId, String itTag) {
        this.unitId = unitId;
        this.itTag = itTag;
    }

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
