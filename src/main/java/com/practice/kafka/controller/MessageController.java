package com.practice.kafka.controller;

import com.practice.kafka.kafka.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Author: SANDEEP
 * Date: 30/12/24
 */

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    //    http:localhost:8080/api/v1/kafka/publish?message=hello First Kafka Message
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        log.info("Message send by MessageController publish() :: {}", message);
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message Send using Kafka SuccessFully....");
    }


}
