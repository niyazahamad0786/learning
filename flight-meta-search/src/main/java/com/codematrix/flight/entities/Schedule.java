package com.codematrix.flight.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Schedule extends BaseEntity {

    @NonNull
    private String departureAirportCode;

    @NonNull
    private String arrivalAirportCode;

    @NonNull
    private String providerCode;

    @NonNull
    private BigDecimal basePrice;
}
