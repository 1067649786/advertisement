package com.ygy.ad.adsearch.search.vo.feature;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ItFeature {

    private List<String> its;

    public ItFeature(List<String> its) {
        this.its = its;
    }

    public List<String> getIts() {
        return its;
    }

    public void setIts(List<String> its) {
        this.its = its;
    }
}
