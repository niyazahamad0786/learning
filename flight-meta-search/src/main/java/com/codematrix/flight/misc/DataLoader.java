package com.codematrix.flight.misc;


import com.codematrix.flight.entities.Airport;
import com.codematrix.flight.entities.Provider;
import com.codematrix.flight.entities.Schedule;
import com.codematrix.flight.repositories.AirportRepository;
import com.codematrix.flight.repositories.ProviderRepository;
import com.codematrix.flight.repositories.ScheduleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component
public class DataLoader implements CommandLineRunner {

    private AirportRepository airportRepository;
    private ProviderRepository providerRepository;
    private ScheduleRepository scheduleRepository;

    public DataLoader(AirportRepository airportRepository, ProviderRepository providerRepository, ScheduleRepository scheduleRepository) {
        this.airportRepository = airportRepository;
        this.providerRepository = providerRepository;
        this.scheduleRepository = scheduleRepository;
    }

    private void insertSchedule(ScheduleRepository scheduleRepository) {
        scheduleRepository.save(new Schedule("AR01", "AR02", "PR01", new BigDecimal(100)));
        scheduleRepository.save(new Schedule("AR03", "AR04", "PR01", new BigDecimal(100)));

        scheduleRepository.save(new Schedule("AR01", "AR02", "PR02", new BigDecimal(100)));
        scheduleRepository.save(new Schedule("AR03", "AR04", "PR02", new BigDecimal(100)));

        scheduleRepository.save(new Schedule("AR01", "AR02", "PR04", new BigDecimal(100)));
        scheduleRepository.save(new Schedule("AR03", "AR04", "PR04", new BigDecimal(100)));

        scheduleRepository.save(new Schedule("AR01", "AR03", "PR02", new BigDecimal(100)));
        scheduleRepository.save(new Schedule("AR02", "AR04", "PR02", new BigDecimal(100)));

        scheduleRepository.save(new Schedule("AR01", "AR04", "PR03", new BigDecimal(100)));
        scheduleRepository.save(new Schedule("AR02", "AR03", "PR03", new BigDecimal(100)));

        scheduleRepository.save(new Schedule("AR01", "AR04", "PR02", new BigDecimal(100)));
        scheduleRepository.save(new Schedule("AR02", "AR03", "PR02", new BigDecimal(100)));

        scheduleRepository.save(new Schedule("AR01", "AR02", "PR04", new BigDecimal(100)));
        scheduleRepository.save(new Schedule("AR02", "AR01", "PR04", new BigDecimal(100)));

    }

    private void insertProvider(ProviderRepository providerRepository) {
        providerRepository.save(new Provider("PR01", "Provider 1"));
        providerRepository.save(new Provider("PR02", "Provider 2"));
        providerRepository.save(new Provider("PR03", "Provider 3"));
        providerRepository.save(new Provider("PR04", "Provider 4"));
        providerRepository.save(new Provider("PR05", "Provider 5"));
    }

    private void insertAirport(AirportRepository airportRepository) {
        airportRepository.save(new Airport("AR01", "Airport 1"));
        airportRepository.save(new Airport("AR02", "Airport 2"));
        airportRepository.save(new Airport("AR03", "Airport 3"));
        airportRepository.save(new Airport("AR04", "Airport 4"));
        airportRepository.save(new Airport("AR05", "Airport 5"));
    }

    @Override
    public void run(String... args) throws Exception {
        insertAirport(airportRepository);
        insertProvider(providerRepository);
        insertSchedule(scheduleRepository);
    }
}
