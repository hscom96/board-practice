package com.example.backend.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserDto {

    private Long userId;

    private String name;

    private String userName;

    public static UserDto of(Long userId, String name, String userName) {
        return UserDto.builder()
            .userId(userId)
            .name(name)
            .userName(userName).build();
    }
}
