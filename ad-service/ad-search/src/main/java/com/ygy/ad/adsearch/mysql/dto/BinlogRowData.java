package com.ygy.ad.adsearch.mysql.dto;

import com.github.shyiko.mysql.binlog.event.EventType;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class BinlogRowData {

    private TableTemplate table;

    private EventType eventType;

    private List<Map<String, String>> after;

    private List<Map<String, String>> before;

    public TableTemplate getTable() {
        return table;
    }

    public void setTable(TableTemplate table) {
        this.table = table;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public List<Map<String, String>> getAfter() {
        return after;
    }

    public void setAfter(List<Map<String, String>> after) {
        this.after = after;
    }

    public List<Map<String, String>> getBefore() {
        return before;
    }

    public void setBefore(List<Map<String, String>> before) {
        this.before = before;
    }
}
