package com.taxi.uber.strategies;

import com.taxi.uber.strategies.imp.DriverMatchingHighestRateStrategy;
import com.taxi.uber.strategies.imp.DriverMatchingNearestDriverStrategy;
import com.taxi.uber.strategies.imp.RideFareDefaultFareCalculationStrategy;
import com.taxi.uber.strategies.imp.RideFarePriceSurgeStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@AllArgsConstructor
public class StrategyManager {

    private final DriverMatchingHighestRateStrategy driverMatchingHighestRateStrategy;
    private final DriverMatchingNearestDriverStrategy driverMatchingNearestDriverStrategy;
    private final RideFarePriceSurgeStrategy rideFarePriceSurgeStrategy;
    private final RideFareDefaultFareCalculationStrategy rideFareDefaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double rating){
        if(rating>=4.8){
            return driverMatchingHighestRateStrategy;
        }else{
            return driverMatchingNearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){
        // 6PM to 9 PM

        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime=currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime){
            return rideFarePriceSurgeStrategy;
        }else{
            return rideFareDefaultFareCalculationStrategy;
        }
    }
}
