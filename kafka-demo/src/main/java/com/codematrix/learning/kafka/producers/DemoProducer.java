package com.codematrix.learning.kafka.producers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoProducer {

    private KafkaTemplate<String, String> kafkaTemplate;

    public DemoProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce() {
        for (int i = 0; i < 1000000; i++) {
            kafkaTemplate.send("demo", String.format("Message %d", i));
            log.info("Sent");
        }
    }
}
