package com.taxi.uber.strategies.imp;

import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.entities.Driver;
import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.repositories.DriverRepository;
import com.taxi.uber.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRateStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearByTopRatedDrivers(rideRequest.getPickUpLocation());
    }
}
