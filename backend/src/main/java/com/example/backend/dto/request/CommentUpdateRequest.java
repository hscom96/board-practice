package com.example.backend.dto.request;

import com.example.backend.model.Comment;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentUpdateRequest {

    private Long parentId;

    @NotBlank(message = "내용이 비어 있습니다.")
    private String content;

    public Comment toEntity(Long articleId, Long currentUserId, Long commentId) {
        return Comment.builder()
            .articleId(articleId)
            .content(content)
            .createdById(currentUserId)
            .commentId(commentId).build();
    }
}
