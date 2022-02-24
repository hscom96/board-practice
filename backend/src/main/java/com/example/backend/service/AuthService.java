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
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserDto login(LoginRequest loginRequest) {
        User user = userRepository.findByUserNameAndPassword(loginRequest.getUserName(), loginRequest.getPassword())
            .orElseThrow(() -> {throw new CustomException(ResponseCode.USER_NOT_FOUND);});
        return UserDto.from(user);
    }

    public UserDto register(RegisterRequest registerRequest) {
        verifyDuplicatedUserName(registerRequest);
        User user = userRepository.save(registerRequest.toEntity());
        return UserDto.from(user);
    }

    private void verifyDuplicatedUserName(RegisterRequest registerRequest) {
        userRepository.findByUserName(registerRequest.getUserName())
            .ifPresent(user->{throw new CustomException(ResponseCode.USER_ID_DUPLICATE);});
    }
}

