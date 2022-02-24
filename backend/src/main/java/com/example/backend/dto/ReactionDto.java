package com.example.backend.dto;

import com.example.backend.model.Reaction;
import com.example.backend.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReactionDto {

    private Long articleId;
    private String type;
    private LocalDateTime createdAt;
    private String createdBy;
    private Long createdById;

    public static ReactionDto of(Reaction reaction, User user){
        return ReactionDto.builder()
            .articleId(reaction.getArticleId())
            .type(reaction.getType())
            .createdAt(reaction.getCreatedAt())
            .createdById(reaction.getUserId())
            .createdBy(user.getUserName()).build();
    }
}
