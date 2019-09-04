package com.ygy.ad.adsearch.index.creativeunit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreativeUnitObject {

    private Long adId;
    private Long unitId;

    // adId-unitId


    public CreativeUnitObject(Long adId, Long unitId) {
        this.adId = adId;
        this.unitId = unitId;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
}
