package com.codematrix.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class FlightMetaSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightMetaSearchApplication.class, args);
    }

}
