package com.codematrix.flight.controllers.requests;

import com.codematrix.flight.dto.ScheduleDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightPriceResponse {

    @JsonProperty("request_id")
    private String requestId;
    private List<ScheduleDto> prices;

}
