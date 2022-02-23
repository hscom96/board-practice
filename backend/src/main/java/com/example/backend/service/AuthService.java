package com.example.backend.service;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import com.example.backend.dto.UserDto;
import com.example.backend.dto.request.LoginRequest;
import com.example.backend.dto.request.RegisterRequest;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    public UserDto login(LoginRequest loginRequest) {
        User user = userRepository.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword())
            .orElseThrow(() -> {throw new CustomException(ResponseCode.PARAM_INVALID);});
        return UserDto.from(user);
    }

    public UserDto register(RegisterRequest registerRequest) {
        User user = userRepository.save(registerRequest.toEntity());
        return UserDto.from(user);
    }
}
