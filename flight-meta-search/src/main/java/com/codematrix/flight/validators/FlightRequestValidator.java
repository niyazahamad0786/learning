package com.codematrix.flight.validators;

import com.codematrix.flight.controllers.responses.FlightPriceRequest;
import com.codematrix.flight.entities.Schedule;
import com.codematrix.flight.exceptions.ErrorCode;
import com.codematrix.flight.exceptions.ValidationException;
import com.codematrix.flight.repositories.ScheduleRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FlightRequestValidator {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public void validateRequest(FlightPriceRequest request) throws ValidationException {
        validateNotNull(request);
        validateAirportCodes(request);
        validateRoute(request);
    }

    private void validateRoute(FlightPriceRequest request) throws ValidationException {
        String departureCode = request.getDepartureAirportCode();
        String arrivalCode = request.getArrivalAirportCode();
        List<Schedule> schedules = scheduleRepository.findAllByDepartureAirportCodeAndArrivalAirportCode(departureCode, arrivalCode);
        if (CollectionUtils.isEmpty(schedules)) {
            throw new ValidationException(ErrorCode.INVALID_VALUE, String.format("No route found by departureCode %s and arrivalCode %s", departureCode, arrivalCode));
        }
    }

    private void validateAirportCodes(FlightPriceRequest request) throws ValidationException {
        String arrivalCode = request.getArrivalAirportCode();
        String departureCode = request.getDepartureAirportCode();
        ValidationUtil.assertNotEquals(departureCode, arrivalCode, ErrorCode.INVALID_VALUE, "Departure code and Arrival code must not be same");
    }

    private void validateNotNull(FlightPriceRequest request) throws ValidationException {
        ValidationUtil.assertNotNull(request.getDepartureAirportCode(), ErrorCode.NULL_VALUE, "Departure airport code must not be null");
        ValidationUtil.assertNotNull(request.getArrivalAirportCode(), ErrorCode.NULL_VALUE, "Arrival airport code must not be null");
        ValidationUtil.assertNotNull(request.getDepartureDate(), ErrorCode.NULL_VALUE, "Departure date must not be null");
    }
}
