package com.taxi.uber.dto;

import com.taxi.uber.entities.RideRequest;
import com.taxi.uber.entities.Rider;
import com.taxi.uber.enums.PaymentMethod;
import com.taxi.uber.enums.RideRequestStatus;
import com.taxi.uber.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideRequestDto {
    private Long id;
    private PointDto pickUpLocation;
    private PointDto dropOffLocation;
    private LocalDateTime requestedTime;
    private PaymentMethod paymentMethod;
    private RiderDto rider;
    private RideRequestStatus rideRequestStatus;
    private double fare;
}
