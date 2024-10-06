package com.taxi.uber.strategies.imp;

import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.services.DistanceService;
import com.taxi.uber.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance=distanceService.calculateDistance(rideRequest.getPickUpLocation(),rideRequest.getDropOffLocation());
        return distance * FARE_MULTIPLIER;
    }
}
