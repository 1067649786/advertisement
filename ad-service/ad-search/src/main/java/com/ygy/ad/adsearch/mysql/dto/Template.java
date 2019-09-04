package com.ygy.ad.adsearch.mysql.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Template {

    private String database;
    private List<JsonTable> tableList;

    public Template(String database, List<JsonTable> tableList) {
        this.database = database;
        this.tableList = tableList;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public List<JsonTable> getTableList() {
        return tableList;
    }

    public void setTableList(List<JsonTable> tableList) {
        this.tableList = tableList;
    }
}
