package com.ygy.ad.adsearch.search.vo.media;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Geo {

    private Float latitude;

    private Float longitude;

    private String city;

    private String province;

    public Geo(Float latitude, Float longitude, String city, String province) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.province = province;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
