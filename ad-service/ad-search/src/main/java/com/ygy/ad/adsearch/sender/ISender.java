package com.ygy.ad.adsearch.sender;

import com.ygy.ad.adsearch.mysql.dto.MySqlRowData;

public interface ISender {

    void sender(MySqlRowData rowData);
}
