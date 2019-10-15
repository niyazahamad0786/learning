package com.codematrix.flight.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class ScheduleDto {

    @NonNull
    private String departureAirportCode;

    @NonNull
    private String arrivalAirportCode;

    @NonNull
    private String providerCode;

    @NonNull
    private Double price;

    @NonNull
    @JsonIgnore
    private LocalDate departureDate;

}
