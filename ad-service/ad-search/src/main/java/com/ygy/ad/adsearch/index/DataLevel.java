package com.ygy.ad.adsearch.index;

import lombok.Getter;

@Getter
public enum  DataLevel {

    LEVEL2("2","level 2"),
    LEVEL3("3","level 3"),
    LEVEL4("4","level 4");

    private String level;
    private String desc;

    DataLevel(String level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public String getLevel() {
        return level;
    }

    public String getDesc() {
        return desc;
    }
}
