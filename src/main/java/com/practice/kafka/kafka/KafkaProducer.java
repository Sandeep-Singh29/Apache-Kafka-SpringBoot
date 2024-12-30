package com.practice.kafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Author: SANDEEP
 * Date: 30/12/24
 */

@Service
@Slf4j
public class KafkaProducer {

    private static final Logger log = LogManager.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;


    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("Message Send ::   {} ", message);
        kafkaTemplate.send("my1Topic", message);
    }


}
