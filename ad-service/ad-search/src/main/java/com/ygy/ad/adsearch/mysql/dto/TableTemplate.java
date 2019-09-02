package com.ygy.ad.adsearch.mysql.dto;

import com.ygy.ad.adsearch.mysql.constant.OpType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TableTemplate {

    private String tableName;
    private String level;

    private Map<OpType, List<String>> opTypeFieldSetMap=new HashMap<>();

    /**
     * 字段索引-》字段名
     */
    private Map<Integer,String> posMap=new HashMap<>();

    public TableTemplate(String tableName, String level, Map<OpType, List<String>> opTypeFieldSetMap, Map<Integer, String> posMap) {
        this.tableName = tableName;
        this.level = level;
        this.opTypeFieldSetMap = opTypeFieldSetMap;
        this.posMap = posMap;
    }

    public TableTemplate(){}

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

    public Map<OpType, List<String>> getOpTypeFieldSetMap() {
        return opTypeFieldSetMap;
    }

    public void setOpTypeFieldSetMap(Map<OpType, List<String>> opTypeFieldSetMap) {
        this.opTypeFieldSetMap = opTypeFieldSetMap;
    }

    public Map<Integer, String> getPosMap() {
        return posMap;
    }

    public void setPosMap(Map<Integer, String> posMap) {
        this.posMap = posMap;
    }
}
