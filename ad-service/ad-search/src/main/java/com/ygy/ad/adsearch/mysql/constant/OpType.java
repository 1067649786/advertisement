package com.ygy.ad.adsearch.mysql.constant;

import com.github.shyiko.mysql.binlog.event.EventType;

public enum OpType {

    ADD,
    UPDATA,
    DELETE,
    OTHER;

    public static OpType to(EventType eventType){

        switch (eventType){
            case EXT_WRITE_ROWS:
                return ADD;
            case EXT_UPDATE_ROWS:
                return UPDATA;
            case EXT_DELETE_ROWS:
                return DELETE;

            default:
                return OTHER;
        }
    }
}
