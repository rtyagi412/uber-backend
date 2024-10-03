package com.taxi.uber.services.imp;

import com.taxi.uber.dto.DriverDto;
import com.taxi.uber.dto.SignUpDto;
import com.taxi.uber.dto.UserDto;
import com.taxi.uber.entities.User;
import com.taxi.uber.enums.Role;
import com.taxi.uber.exceptions.UserAlreadyExistException;
import com.taxi.uber.repositories.UserRepository;
import com.taxi.uber.services.AuthService;
import com.taxi.uber.services.RiderService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImp implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    @Override
    public String login(String username, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDto signUp(SignUpDto signUpDto) {
        User user=userRepository.findByEmail(signUpDto.getEmail()).orElse(null);

        if(Objects.nonNull(user)){
            throw new UserAlreadyExistException("Can not signup, user already exist" + signUpDto.getEmail());
        }

        User mappedUser=modelMapper.map(signUpDto,User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));

        User savedUser=userRepository.save(mappedUser);

        riderService.createNewRider(savedUser);

        //TODO Wallet

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
