package com.ygy.ad.adsearch.sender.kafka;

import com.alibaba.fastjson.JSON;
import com.ygy.ad.adsearch.mysql.dto.MySqlRowData;
import com.ygy.ad.adsearch.sender.ISender;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("kafkaSender")
public class KafkaSender implements ISender {

    @Value("${adconf.kafka.topic}")
    private String topic;

    @Autowired
    private final KafkaTemplate<String,String> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sender(MySqlRowData rowData) {

        kafkaTemplate.send(topic, JSON.toJSONString(rowData));
    }

    @KafkaListener(topics = {"ad-search-mysql-data"},groupId = "ad-search")
    public void processMysqlRowData(ConsumerRecord<?,?> record){

        Optional<?> kafkaMessage=Optional.ofNullable(record.value());

        if(kafkaMessage.isPresent()){
            Object message=kafkaMessage.get();
            MySqlRowData rowData=JSON.parseObject(message.toString(),MySqlRowData.class);
            System.out.println("kafka processMysqlRowData:"+JSON.toJSONString(rowData));
        }
    }
}
