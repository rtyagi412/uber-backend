package com.taxi.uber.strategies;

import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.entities.RideRequest;

public interface RideFareCalculationStrategy {
    double FARE_MULTIPLIER=10;
    double calculateFare(RideRequest rideRequest);
}
