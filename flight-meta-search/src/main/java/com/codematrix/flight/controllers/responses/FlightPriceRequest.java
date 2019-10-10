package com.codematrix.flight.controllers.responses;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightPriceRequest {

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("dep_air_code")
    private String departureAirportCode;

    @JsonProperty("arr_air_code")
    private String arrivalAirportCode;

    @JsonProperty("dep_date")
    private LocalDate departureDate;
}
