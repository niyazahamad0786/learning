package com.codematrix.flight.repositories;

import com.codematrix.flight.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findByCode(String code);
}
