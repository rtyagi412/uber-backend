package com.taxi.uber.services;

import com.taxi.uber.dto.DriverDto;
import com.taxi.uber.dto.RideDto;
import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.dto.RiderDto;
import com.taxi.uber.entities.Rider;
import com.taxi.uber.entities.User;

import java.util.List;

public interface RiderService {
    RideRequestDto requestRide(RideRequestDto  rideRequestDto);
    RideDto cancelRide(Long rideId);
    List<RideDto> getAllMyRides();
    RiderDto myProfile();
    DriverDto rateDriver(Long rideId, Integer rating);
    Rider createNewRider(User user);
    Rider getCurrentRider();
}
