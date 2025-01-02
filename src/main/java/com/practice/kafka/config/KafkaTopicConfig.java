package com.practice.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Author: SANDEEP
 * Date: 30/12/24
 */

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name("my1Topic")
                .build();
    }


    @Bean
    public NewTopic newTopicJson(){
        return TopicBuilder.name("my1Topic_json")
                .build();
    }

}
