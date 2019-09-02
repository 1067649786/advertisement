package com.ygy.ad.adsearch.mysql.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class JsonTable {

    private String tableName;
    private Integer level;

    private List<Column> insert;
    private List<Column> update;
    private List<Column> delete;

    public JsonTable(String tableName, Integer level, List<Column> insert, List<Column> update, List<Column> delete) {
        this.tableName = tableName;
        this.level = level;
        this.insert = insert;
        this.update = update;
        this.delete = delete;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Column> getInsert() {
        return insert;
    }

    public void setInsert(List<Column> insert) {
        this.insert = insert;
    }

    public List<Column> getUpdate() {
        return update;
    }

    public void setUpdate(List<Column> update) {
        this.update = update;
    }

    public List<Column> getDelete() {
        return delete;
    }

    public void setDelete(List<Column> delete) {
        this.delete = delete;
    }

    @Data
    @NoArgsConstructor
    public static class Column{
        private String column;

        public Column(String column) {
            this.column = column;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }
    }
}
