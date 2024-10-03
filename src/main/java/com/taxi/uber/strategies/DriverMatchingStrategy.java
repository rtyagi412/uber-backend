package com.taxi.uber.strategies;

import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.entities.Driver;
import com.taxi.uber.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

   List<Driver> findMatchingDriver(RideRequest rideRequest);
}
