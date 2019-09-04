package com.ygy.ad.adsponsor.constant;

import lombok.Getter;

@Getter
public enum  CreativeType {

    IMAGE(1,"图片"),
    VIDEO(2,"视频"),
    Text(3,"文本");

    private int type;
    private String desc;

    CreativeType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
