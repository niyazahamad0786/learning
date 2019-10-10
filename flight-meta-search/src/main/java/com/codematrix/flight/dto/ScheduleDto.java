package com.codematrix.flight.dto;


import com.codematrix.flight.entities.Schedule;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleDto extends Schedule {

    @JsonProperty("dep_date")
    private LocalDate departureDate;
}
