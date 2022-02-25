package com.example.backend.dto.request;

import com.example.backend.model.Comment;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentCreateRequest {

    private static final long parent = -1;

    private Long parentId;

    @NotBlank(message = "content is empty")
    private String content;

    public Comment toEntity(Long articleId, Long currentUserId) {
        return Comment.builder()
            .parentId(parent)
            .articleId(articleId)
            .content(content)
            .createdById(currentUserId).build();
    }
}
