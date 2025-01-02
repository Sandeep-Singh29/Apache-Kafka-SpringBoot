package com.practice.kafka.kafka;

import com.practice.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Author: SANDEEP
 * Date: 31/12/24
 */

@Service
public class KafkaProducerJSON {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerJSON.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public KafkaProducerJSON(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(User data) {
        log.info("User send  into KafkaProducerJSON Service  :: {}", data.toString());
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "my1Topic_json")
                .build();
        kafkaTemplate.send(message);
    }


}
