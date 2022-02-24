package com.example.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Pageable;

@Getter
@Builder
@AllArgsConstructor
public class CommentListResponseDto {

    private int currentPage;
    private int totalPage;
    private Comments comments;

    public static CommentListResponseDto of(Comments comments, Pageable pageable) {
        return CommentListResponseDto.builder()
            .currentPage(pageable.getPageNumber())
            .totalPage(pageable.getPageNumber())
            .comments(comments).build();
    }
}
