package com.ygy.ad.adsearch.search.vo.feature;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DistrictFeature {

    private List<ProvinceAndCity> districts;

    public DistrictFeature(List<ProvinceAndCity> districts) {
        this.districts = districts;
    }

    public List<ProvinceAndCity> getDistricts() {
        return districts;
    }

    public void setDistricts(List<ProvinceAndCity> districts) {
        this.districts = districts;
    }

    public static class ProvinceAndCity{

        private String province;
        private String city;

        public ProvinceAndCity(String province, String city) {
            this.province = province;
            this.city = city;
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
