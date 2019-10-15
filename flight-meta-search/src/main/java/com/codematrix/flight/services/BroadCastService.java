package com.codematrix.flight.services;


import com.codematrix.flight.controllers.responses.FlightPriceRequest;
import com.codematrix.flight.dto.ScheduleDto;
import com.codematrix.flight.entities.Schedule;
import com.codematrix.flight.repositories.AirportRepository;
import com.codematrix.flight.repositories.ProviderRepository;
import com.codematrix.flight.repositories.ScheduleRepository;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BroadCastService {

    private ProviderRepository providerRepository;
    private AirportRepository airportRepository;
    private ScheduleRepository scheduleRepository;
    private RedisTemplate<String, ScheduleDto> redisTemplate;

    public BroadCastService(ProviderRepository providerRepository, AirportRepository airportRepository, ScheduleRepository scheduleRepository, RedisTemplate<String, ScheduleDto> redisTemplate) {
        this.providerRepository = providerRepository;
        this.airportRepository = airportRepository;
        this.scheduleRepository = scheduleRepository;
        this.redisTemplate = redisTemplate;
    }

    private void broadCast(String depCode, String arrCode, String searchId, LocalDate departureDate) {
        List<Schedule> schedules = scheduleRepository.findAllByDepartureAirportCodeAndArrivalAirportCode(depCode, arrCode);
        List<ScheduleDto> dtos = schedules.stream().map(schedule -> updatePrice(schedule, departureDate)).collect(Collectors.toList());
        BoundListOperations<String, ScheduleDto> boundListOperations = redisTemplate.boundListOps(searchId);
        dtos.forEach(dto -> boundListOperations.rightPush(dto));
    }

    private ScheduleDto updatePrice(Schedule schedule, LocalDate departureDate) {
        //  price = base price ± random() * 0.3 * base price
        BigDecimal basePrice = schedule.getBasePrice();
        BigDecimal price = basePrice.add(new BigDecimal(0.3).multiply(new BigDecimal(RandomUtils.nextInt())).multiply(basePrice));
        Double roundingPrice = price.setScale(2, RoundingMode.CEILING).doubleValue();
        return new ScheduleDto(schedule.getDepartureAirportCode(), schedule.getArrivalAirportCode(), schedule.getProviderCode(), roundingPrice, departureDate);
    }

    public void broadCast(FlightPriceRequest request) {
        broadCast(request.getDepartureAirportCode(), request.getArrivalAirportCode(), request.getSearchId(), request.getDepartureDate());
    }
}
