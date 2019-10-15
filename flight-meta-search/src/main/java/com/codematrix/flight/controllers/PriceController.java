package com.codematrix.flight.controllers;


import com.codematrix.flight.controllers.requests.FlightPriceResponse;
import com.codematrix.flight.controllers.responses.FlightPriceRequest;
import com.codematrix.flight.exceptions.ErrorCode;
import com.codematrix.flight.exceptions.ValidationException;
import com.codematrix.flight.services.PriceFetcherService;
import com.codematrix.flight.validators.FlightRequestValidator;
import com.codematrix.flight.validators.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.nio.charset.Charset;

@RestController
@RequestMapping("api/flight/price")
@Slf4j
public class PriceController {

    private PriceFetcherService priceFetcherService;
    private FlightRequestValidator flightRequestValidator;

    public PriceController(PriceFetcherService priceFetcherService, FlightRequestValidator flightRequestValidator) {
        this.priceFetcherService = priceFetcherService;
        this.flightRequestValidator = flightRequestValidator;
    }

    @PostMapping("/v1/search")
    public FlightPriceResponse fetchFlightPrice(@RequestBody FlightPriceRequest request) {
        try {
            flightRequestValidator.validateRequest(request);
            return priceFetcherService.fetchFlightPrices(request);
        } catch (ValidationException e) {
            log.error("Error while validation of request", e);
            throw HttpClientErrorException.create(HttpStatus.BAD_REQUEST, e.getMessage(), HttpHeaders.EMPTY, request.toString().getBytes(), Charset.defaultCharset());
        } catch (Exception e) {
            throw HttpClientErrorException.create(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), HttpHeaders.EMPTY, request.toString().getBytes(), Charset.defaultCharset());
        }
    }

    @GetMapping(path = "/v1/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public FlightPriceResponse fetchFlightPricePost(FlightPriceRequest request) {
        try {
            flightRequestValidator.validateRequest(request);
            return priceFetcherService.fetchFlightPrices(request);
        } catch (ValidationException e) {
            log.error("Error while validation of request", e);
            throw HttpClientErrorException.create(HttpStatus.BAD_REQUEST, e.getMessage(), HttpHeaders.EMPTY, request.toString().getBytes(), Charset.defaultCharset());
        } catch (Exception e) {
            throw HttpClientErrorException.create(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), HttpHeaders.EMPTY, request.toString().getBytes(), Charset.defaultCharset());
        }
    }

    @PostMapping("/v1/poll")
    public FlightPriceResponse pollFlightPrice(@RequestBody FlightPriceRequest request) {
        try {
            ValidationUtil.assertNotNull(request.getSearchId(), ErrorCode.NULL_VALUE, "search_id must not be null");
            return priceFetcherService.pollFlightPrices(request);
        } catch (ValidationException e) {
            log.error("Error while validation of request", e);
            throw HttpClientErrorException.create(HttpStatus.BAD_REQUEST, e.getMessage(), HttpHeaders.EMPTY, request.toString().getBytes(), Charset.defaultCharset());
        } catch (Exception e) {
            throw HttpClientErrorException.create(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), HttpHeaders.EMPTY, request.toString().getBytes(), Charset.defaultCharset());
        }
    }
}
