package com.example.backend.controller;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.dto.UserDto;
import com.example.backend.dto.common.CommonResponse;
import com.example.backend.dto.request.LoginRequest;
import com.example.backend.dto.request.RegisterRequest;
import com.example.backend.service.AuthService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<?>> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, null));
    }

    @PostMapping("/register")
    public ResponseEntity<CommonResponse<UserDto>> register(
        @RequestBody @Valid RegisterRequest registerRequest) {
        UserDto userDto = authService.register(registerRequest);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, userDto));
    }
}
