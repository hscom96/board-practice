package com.example.backend.dto;

import com.example.backend.model.User;
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

    public static UserDto from(User user){
        return UserDto.builder()
            .userId(user.getUserId())
            .name(user.getName())
            .userName(user.getUserName()).build();
    }
}
