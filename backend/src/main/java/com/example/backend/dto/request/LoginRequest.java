package com.example.backend.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequest {

    @NotBlank(message = "name is empty")
    private String userName;

    @NotBlank(message = "password is empty")
    private String password;
}
