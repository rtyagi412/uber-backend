package com.taxi.uber.strategies.imp;

import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.entities.Driver;
import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.repositories.DriverRepository;
import com.taxi.uber.strategies.DriverMatchingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {
    private final DriverRepository driverRepository;
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickUpLocation());
    }
}
