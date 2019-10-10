package com.codematrix.flight.controllers;


import com.codematrix.flight.controllers.requests.FlightPriceResponse;
import com.codematrix.flight.controllers.responses.FlightPriceRequest;
import com.codematrix.flight.services.PriceFetcherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/flight/price")
public class PriceController {

    private PriceFetcherService priceFetcherService;

    @GetMapping("/v1/search")
    public FlightPriceResponse fetchFlightPrice(@RequestParam FlightPriceRequest flightPriceRequest) {
        return null;
    }
}
