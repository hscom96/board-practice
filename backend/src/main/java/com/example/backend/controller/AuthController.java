package com.example.backend.controller;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.dto.UserDto;
import com.example.backend.dto.common.CommonResponse;
import com.example.backend.dto.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RestController
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<CommonResponse<?>> login(@RequestBody LoginRequest loginRequest) {
        UserDto userDto = UserDto.of(1L, "name", "userName");
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, userDto));
    }
}
