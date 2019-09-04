package com.ygy.ad.adcommon.dump.table;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.CORBA.PUBLIC_MEMBER;

@Data
public class AdCreativeUnitTable {

    private Long adId;
    private Long unitId;

    public AdCreativeUnitTable(Long adId, Long unitId) {
        this.adId = adId;
        this.unitId = unitId;
    }

    public AdCreativeUnitTable(){}

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
