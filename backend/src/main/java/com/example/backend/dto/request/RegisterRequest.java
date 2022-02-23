package com.example.backend.dto.request;

import com.example.backend.model.User;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "name is empty")
    private String name;

    @NotBlank(message = "userName is empty")
    private String userName;

    @NotBlank(message = "password is empty")
    private String password;

    public User toEntity() {
        return User.builder()
            .name(name)
            .userName(userName)
            .password(password)
            .lastLoginAt(LocalDateTime.now())
            // TODO: user Role enum 생성
            .userRole("user").build();
    }
}
