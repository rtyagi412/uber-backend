package com.taxi.uber.services.imp;

import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.entities.Driver;
import com.taxi.uber.entities.Ride;
import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.enums.RideRequestStatus;
import com.taxi.uber.enums.RideStatus;
import com.taxi.uber.exceptions.ResourceNotFoundException;
import com.taxi.uber.repositories.RideRepository;
import com.taxi.uber.services.RideRequestService;
import com.taxi.uber.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RideServiceImp implements RideService {

    private final ModelMapper modelMapper;
    private final RideRepository rideRepository;
    private final RideRequestService rideRequestService;

    @Override
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId).orElseThrow(()->new ResourceNotFoundException("Id not found"))  ;
    }

    @Override
    public void matchWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequest rideRequest, Driver driver) {
        rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);
        Ride ride=modelMapper.map(rideRequest,Ride.class);
        ride.setRideStatus(RideStatus.CONFIRMED);
        ride.setDriver(driver);
        ride.setOtp(generateOtp());
        ride.setId(null);
        rideRequestService.update(rideRequest);
        return rideRepository.save(ride);
    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
        ride.setRideStatus(rideStatus);
        return rideRepository.save(ride);
    }

    @Override
    public List<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
        return List.of();
    }

    @Override
    public List<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
        return List.of();
    }

    private String generateOtp(){
        Random random=new Random();
        int otp=random.nextInt(10000);
        return String.format("%04d",otp);
    }
}
