package com.ygy.ad.adsearch.mysql.dto;

import com.ygy.ad.adsearch.mysql.constant.OpType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class MySqlRowData {

    private String tableName;

    private String level;

    private OpType opType;

    private List<Map<String,String>> fieldValueMap=new ArrayList<>();

    public MySqlRowData(String tableName, String level, OpType opType, List<Map<String, String>> fieldValueMap) {
        this.tableName = tableName;
        this.level = level;
        this.opType = opType;
        this.fieldValueMap = fieldValueMap;
    }

    public MySqlRowData(){}

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public OpType getOpType() {
        return opType;
    }

    public void setOpType(OpType opType) {
        this.opType = opType;
    }

    public List<Map<String, String>> getFieldValueMap() {
        return fieldValueMap;
    }

    public void setFieldValueMap(List<Map<String, String>> fieldValueMap) {
        this.fieldValueMap = fieldValueMap;
    }
}
