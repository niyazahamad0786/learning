package com.codematrix.flight.repositories;

import com.codematrix.flight.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByDepartureAirportCodeAndArrivalAirportCode(String departureCode, String arrivalCode);
}
