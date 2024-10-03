package com.taxi.uber.dto;

import com.taxi.uber.entities.Driver;
import com.taxi.uber.entities.Rider;
import com.taxi.uber.enums.PaymentMethod;
import com.taxi.uber.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {
    private Long id;
    private Point pickUpLocation;
    private Point dropOffLocation;
    private RiderDto rider;
    private DriverDto driver;
    private LocalDateTime CreatedAt;
    private PaymentMethod paymentMethod;
    private RideStatus rideStatus;
    private double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private String otp;
}
