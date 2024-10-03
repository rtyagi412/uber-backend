package com.taxi.uber.services.imp;

import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.entities.Driver;
import com.taxi.uber.entities.Ride;
import com.taxi.uber.enums.RideStatus;
import com.taxi.uber.services.RideService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServiceImp implements RideService {
    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }

    @Override
    public void matchWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequestDto rideRequestDto, Driver driver) {
        return null;
    }

    @Override
    public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public List<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
        return List.of();
    }

    @Override
    public List<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
        return List.of();
    }
}
