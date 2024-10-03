package com.taxi.uber.controllers;

import com.taxi.uber.dto.RideRequestDto;
import com.taxi.uber.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rider")
@RequiredArgsConstructor
public class RiderController {

    private final RiderService riderService;

    @GetMapping(path = "/requestRide")
    public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto){
        return ResponseEntity.ok(riderService.requestRide(rideRequestDto));
    }
}
