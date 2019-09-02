package com.ygy.ad.adsearch.mysql;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.ygy.ad.adsearch.index.adunit.AdUnitIndex;
import com.ygy.ad.adsearch.mysql.listener.AggregationListener;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@Component
public class BinlogClient {

    private Logger logger= LoggerFactory.getLogger(BinlogClient.class);

    private BinaryLogClient client;

    @Autowired
    private BinlogConfig config;

    @Autowired
    private AggregationListener listener;

    public void connect(){

        new Thread(() -> {
            client=new BinaryLogClient(
                    config.getHost(),
                    config.getPort(),
                    config.getUsername(),
                    config.getPassword()
            );

            if(!StringUtils.isEmpty(config.getBinlogName()) && !config.getPosition().equals(-1L)){

                client.setBinlogFilename(config.getBinlogName());
                client.setBinlogPosition(config.getPosition());
            }

            client.registerEventListener(listener);

            try{
                logger.info("connecting to mysql start");
                client.connect();
                logger.info("connection to mysql done");
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }).start();
    }

    public void close(){

        try{
            client.disconnect();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
