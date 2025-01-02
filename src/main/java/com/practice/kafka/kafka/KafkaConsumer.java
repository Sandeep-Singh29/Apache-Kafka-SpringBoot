package com.practice.kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Author: SANDEEP
 * Date: 31/12/24
 */

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "my1Topic", groupId = "myGroup")
    public void consume(String message) {
        log.info("Message Received By Kafka-Consumer consume() :: {}", message);
    }

}
