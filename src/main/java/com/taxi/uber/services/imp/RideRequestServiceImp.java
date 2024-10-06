package com.taxi.uber.services.imp;

import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.exceptions.ResourceNotFoundException;
import com.taxi.uber.repositories.RideRequestRepository;
import com.taxi.uber.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImp implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideRequestId) {
        return rideRequestRepository.findById(rideRequestId).orElseThrow(()->new ResourceNotFoundException("Request id not found"));
    }

    @Override
    public void update(RideRequest rideRequest) {
        RideRequest savedRideRequest=rideRequestRepository.findById(rideRequest.getId()).orElseThrow(()->new
                ResourceNotFoundException("Request id not found"));

        rideRequestRepository.save(savedRideRequest);
    }
}
