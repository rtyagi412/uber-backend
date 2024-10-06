package com.taxi.uber.services;

import com.taxi.uber.dto.RideDto;
import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.entities.Driver;
import com.taxi.uber.entities.Ride;
import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.enums.RideStatus;
import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RideService {


    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequest rideRequest, Driver driver);

    Ride updateRideStatus(Ride ride, RideStatus rideStatus);

    List<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);

    List<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
}
