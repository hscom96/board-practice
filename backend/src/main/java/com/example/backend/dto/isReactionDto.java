package com.example.backend.dto;

import com.example.backend.model.Reaction;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class isReactionDto {

    private boolean isLiked;
    private boolean isSad;
    private boolean isUpset;

    public static isReactionDto of(List<Reaction> reactions){
        isReactionDto isReactionDto = new isReactionDto();
        for(Reaction reaction : reactions){
            String type = reaction.getType();
            if ("upset".equalsIgnoreCase(type)) {
                isReactionDto.isUpset = true;
            } else if ("sad".equalsIgnoreCase(type)) {
                isReactionDto.isSad = true;
            } else if ("like".equalsIgnoreCase(type)) {
                isReactionDto.isLiked = true;
            }
        }
        return isReactionDto;
    }
}
