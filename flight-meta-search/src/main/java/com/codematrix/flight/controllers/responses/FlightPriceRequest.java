package com.codematrix.flight.controllers.responses;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@NoArgsConstructor
public class FlightPriceRequest {

    @JsonProperty("search_id")
    private String searchId;

    @JsonProperty("dep_air_code")
    private String departureAirportCode;

    @JsonProperty("arr_air_code")
    private String arrivalAirportCode;

    @JsonProperty("dep_date")
    private LocalDate departureDate;
}
