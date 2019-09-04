package com.ygy.ad.adsponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdUnitResponse {

    private Long id;
    private String unitName;

    public AdUnitResponse(Long id, String unitName) {
        this.id = id;
        this.unitName = unitName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
