package com.taxi.uber.controllers;

import com.taxi.uber.dto.SignUpDto;
import com.taxi.uber.dto.UserDto;
import com.taxi.uber.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(path = "/signUp")
    UserDto singUp(@RequestBody SignUpDto signUpDto){
        return authService.signUp(signUpDto);
    }
}
