package com.codematrix.flight.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;


@Getter
@Setter
@Component
@Validated
@ConfigurationProperties("flight-meta-search")
public class FlightMetaSearch {
    private Integer corePoolSize;
    private Integer maxPoolSize;
    private String redisHost;
    private Integer redisPort;
}
