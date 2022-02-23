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

    private static final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}";

    @NotBlank(message = "name is empty")
    private String name;

    @NotBlank(message = "userName is empty")
    private String userName;

    @NotBlank(message = "password is empty")
    @Pattern(regexp = PASSWORD_PATTERN,
        message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
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
