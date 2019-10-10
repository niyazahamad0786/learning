package com.codematrix.learning.kafka.consumers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DemoConsumer {

    @KafkaListener(topics = "demo")
    public void consume(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition) {
        log.info("Consumed message : {} from partition {}", message, partition);
    }
}
