package com.ygy.ad.adsponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdUnitDistrictRequest {

    private List<UnitDistrict> unitDistricts;

    public AdUnitDistrictRequest(List<UnitDistrict> unitDistricts) {
        this.unitDistricts = unitDistricts;
    }

    public List<UnitDistrict> getUnitDistricts() {
        return unitDistricts;
    }

    public void setUnitDistricts(List<UnitDistrict> unitDistricts) {
        this.unitDistricts = unitDistricts;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnitDistrict{

        private Long unitId;
        private String province;
        private String city;

        public Long getUnitId() {
            return unitId;
        }

        public void setUnitId(Long unitId) {
            this.unitId = unitId;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
