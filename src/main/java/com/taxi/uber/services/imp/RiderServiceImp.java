package com.taxi.uber.services.imp;

import com.taxi.uber.dto.DriverDto;
import com.taxi.uber.dto.RideDto;
import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.dto.RiderDto;
import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.entities.Rider;
import com.taxi.uber.entities.User;
import com.taxi.uber.enums.RideRequestStatus;
import com.taxi.uber.repositories.RideRequestRepository;
import com.taxi.uber.repositories.RiderRepository;
import com.taxi.uber.services.RiderService;
import com.taxi.uber.strategies.StrategyManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RiderServiceImp implements RiderService {

    private final ModelMapper modelMapper;
    private final StrategyManager strategyManager;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest=modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(getCurrentRider());
        double fare=strategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);
        RideRequest savedRequest=rideRequestRepository.save(rideRequest);
        strategyManager.driverMatchingStrategy(getCurrentRider().getRating()).findMatchingDriver(rideRequest);
        return modelMapper.map(savedRequest,RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public RiderDto myProfile() {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    public Rider createNewRider(User user){
        Rider rider=Rider.builder().user(user).rating(0.0).build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        //TO DO
        return riderRepository.findById(1L).orElseThrow(()->new ResolutionException("Rider not found with id"));
    }
}
