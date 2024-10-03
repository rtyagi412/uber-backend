package com.taxi.uber.strategies.imp;

import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.services.DistanceService;
import com.taxi.uber.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RideFarePriceSurgeStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;
    private static final double SURGE_FACTOR=2;

    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance=distanceService.calculateDistance(rideRequest.getPickUpLocation(),rideRequest.getDropOffLocation());
        return distance * FARE_MULTIPLIER *SURGE_FACTOR;
    }
}
