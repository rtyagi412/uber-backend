package com.taxi.uber.services;

import com.taxi.uber.dto.DriverDto;
import com.taxi.uber.dto.SignUpDto;
import com.taxi.uber.dto.UserDto;

public interface AuthService {
    String login(String username,String password);

    UserDto signUp(SignUpDto signUpDto);

    DriverDto onboardNewDriver(Long userId);
}
