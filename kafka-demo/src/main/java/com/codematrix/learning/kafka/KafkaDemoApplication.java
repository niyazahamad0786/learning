package com.codematrix.learning.kafka;

import com.codematrix.learning.kafka.producers.DemoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;


@SpringBootApplication
@EnableKafka
public class KafkaDemoApplication {

    @Autowired
    private DemoProducer demoProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return args -> demoProducer.produce();
    }
}
