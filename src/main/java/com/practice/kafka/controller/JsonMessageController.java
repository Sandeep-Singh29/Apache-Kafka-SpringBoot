package com.practice.kafka.controller;

import com.practice.kafka.kafka.KafkaProducerJSON;
import com.practice.kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: SANDEEP
 * Date: 31/12/24
 */

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private static final Logger log = LoggerFactory.getLogger(JsonMessageController.class);

    private final KafkaProducerJSON kafkaProducerJSON;

    public JsonMessageController(KafkaProducerJSON kafkaProducerJSON) {
        this.kafkaProducerJSON = kafkaProducerJSON;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishJsonData(@RequestBody User user) {
        log.info("Message send by JsonMessageController publishJsonData() :: {}", user.toString());
        kafkaProducerJSON.sendMessage(user);
        return ResponseEntity.ok("Message Send to Kafka Topics Successfully.... ");
    }


}
