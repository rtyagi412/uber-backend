package com.taxi.uber.services.imp;

import com.taxi.uber.dto.DriverDto;
import com.taxi.uber.dto.RideDto;
import com.taxi.uber.dto.RiderDto;
import com.taxi.uber.entities.Driver;
import com.taxi.uber.entities.Ride;
import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.enums.RideRequestStatus;
import com.taxi.uber.enums.RideStatus;
import com.taxi.uber.exceptions.ResourceNotFoundException;
import com.taxi.uber.repositories.DriverRepository;
import com.taxi.uber.services.DriverService;
import com.taxi.uber.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImp implements DriverService {
    private final RideRequestService rideRequestService;
    private final DriverRepository driverRepository;
    private final RideServiceImp rideServiceImp;
    private final ModelMapper modelMapper;


    @Override
    public RideDto acceptRide(Long rideRequestId) {
        RideRequest rideRequest= rideRequestService.findRideRequestById(rideRequestId);

        if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)){
            throw new RuntimeException("Ride request can not be accepted "+ rideRequest.getRideRequestStatus());
        }

        Driver driver=getCurrentDriver();

        if(!driver.getAvailable()){
            throw new RuntimeException("Driver not available : ");
        }

        driver.setAvailable(false);
        Driver savedDriver=driverRepository.save(driver);

        Ride ride=rideServiceImp.createNewRide(rideRequest,savedDriver);

        return modelMapper.map(ride,RideDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto startRide(Long rideId, String otp) {
        Ride ride=rideServiceImp.getRideById(rideId);
        Driver driver=getCurrentDriver();

        if(!driver.equals(ride.getDriver())){
            throw new RuntimeException("Driver can not start the ride");
        }

        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
           throw new RuntimeException("Ride status is not confirmed, ride can not be started");
        }

        if(!otp.equals(ride.getOtp())){
            throw new RuntimeException("Otp not valid");
        }

        ride.setStartedAt(LocalDateTime.now());

        Ride savedRide=rideServiceImp.updateRideStatus(ride,RideStatus.ONGOING);

        return modelMapper.map(savedRide,RideDto.class);
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public DriverDto myProfile() {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(()->new ResourceNotFoundException("current driver not found : "+2));
    }
}
