package com.practice.kafka.kafka;

import com.practice.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Author: SANDEEP
 * Date: 31/12/24
 */

@Service
public class KafkaConsumerJSON {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerJSON.class);

    @KafkaListener(topics = "my1Topic_json", groupId = "myGroup")
    public void consumeJsonData(User user) {
        log.info("Message Received By Kafka-Consumer consumeJsonData() :: {}", user.toString());
    }

}
