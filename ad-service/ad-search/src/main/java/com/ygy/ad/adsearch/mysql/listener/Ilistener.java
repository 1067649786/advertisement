package com.ygy.ad.adsearch.mysql.listener;

import com.ygy.ad.adsearch.mysql.dto.BinlogRowData;

public interface Ilistener {

    void register();

    void onEvent(BinlogRowData eventData);
}
