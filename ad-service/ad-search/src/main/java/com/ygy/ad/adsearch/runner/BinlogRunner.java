package com.ygy.ad.adsearch.runner;

import com.ygy.ad.adsearch.mysql.BinlogClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BinlogRunner implements CommandLineRunner {

    private Logger logger= LoggerFactory.getLogger(BinlogRunner.class);

    @Autowired
    private final BinlogClient client;

    public BinlogRunner(BinlogClient client) {
        this.client = client;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Coming in BinlogRunner...");
        client.connect();
    }
}
