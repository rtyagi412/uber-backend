package com.taxi.uber.services;

import com.taxi.uber.dto.DriverDto;
import com.taxi.uber.dto.RideDto;
import com.taxi.uber.dto.RiderDto;

import java.util.List;

public interface DriverService {
    RideDto acceptRide(Long rideId);
    RideDto cancelRide(Long rideId);
    RideDto startRide(Long rideId);
    RideDto endRide(Long rideId);
    List<RideDto> getAllMyRides();
    DriverDto myProfile();
    RiderDto rateRider(Long rideId, Integer rating);
}
