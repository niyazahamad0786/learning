package com.codematrix.flight.controllers.requests;

import com.codematrix.flight.dto.ScheduleDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@RequiredArgsConstructor
@NoArgsConstructor
public class FlightPriceResponse {

    @NonNull
    @JsonProperty("search_id")
    private String searchId;
    private List<ScheduleDto> prices;

}
