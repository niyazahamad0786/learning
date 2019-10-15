package com.codematrix.flight.services;


import com.codematrix.flight.controllers.requests.FlightPriceResponse;
import com.codematrix.flight.controllers.responses.FlightPriceRequest;
import com.codematrix.flight.dto.ScheduleDto;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class PriceFetcherService {

    private static final Integer DEFAULT_SIZE = 5;

    private AsyncTaskExecutor asyncTaskExecutor;
    private BroadCastService broadCastService;
    private RedisTemplate<String, ScheduleDto> redisTemplate;

    public PriceFetcherService(AsyncTaskExecutor asyncTaskExecutor, BroadCastService broadCastService, RedisTemplate<String, ScheduleDto> redisTemplate) {
        this.asyncTaskExecutor = asyncTaskExecutor;
        this.broadCastService = broadCastService;
        this.redisTemplate = redisTemplate;
    }

    public FlightPriceResponse fetchFlightPrices(FlightPriceRequest request) {
        request.setSearchId(UUID.randomUUID().toString());
        asyncTaskExecutor.submit(() -> broadCastService.broadCast(request));
        return new FlightPriceResponse(request.getSearchId());
    }

    public FlightPriceResponse pollFlightPrices(FlightPriceRequest request) {
        String searchId = request.getSearchId();
        // remove from cache
        List<ScheduleDto> dtos = new ArrayList<>();
        BoundListOperations<String, ScheduleDto> boundListOperations = redisTemplate.boundListOps(searchId);
        if (boundListOperations.size() <= 0) {
            return new FlightPriceResponse(searchId);
        }

        Long pageSize = boundListOperations.size() > DEFAULT_SIZE ? DEFAULT_SIZE: boundListOperations.size();

        for (int i = 0; i < pageSize; i++) {
            dtos.add(boundListOperations.leftPop());
        }
        FlightPriceResponse response = new FlightPriceResponse();
        response.setSearchId(searchId);
        response.setPrices(dtos);
        return response;
    }
}
