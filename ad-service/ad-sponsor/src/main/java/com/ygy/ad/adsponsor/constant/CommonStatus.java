package com.ygy.ad.adsponsor.constant;

import lombok.Getter;

@Getter
public enum CommonStatus {

    VALID(1,"有效状态"),
    INVALID(0,"无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status,String desc){
        this.desc=desc;
        this.status=status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
