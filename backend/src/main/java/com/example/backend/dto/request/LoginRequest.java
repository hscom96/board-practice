package com.example.backend.dto.request;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequest {

    @NotEmpty(message = "name is empty")
    private String userName;

    @NotEmpty(message = "password is empty")
    private String password;
}
