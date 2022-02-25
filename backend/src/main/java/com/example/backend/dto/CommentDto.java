package com.example.backend.dto;

import com.example.backend.common.util.Timeutil;
import com.example.backend.model.Comment;
import com.example.backend.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentDto {

    private Long commentId;
    private Long parentId;
    private Long articleId;
    private String content;

    private long createdAt;
    private Long createdById;

    private long modifiedAt;
    private Long modifiedById;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String modifiedBy;

    public static CommentDto from(Comment comment, User user) {
        return CommentDto.builder()
            .commentId(comment.getCommentId())
            .parentId(comment.getParentId())
            .articleId(comment.getArticleId())
            .content(comment.getContent())
            .createdAt(Timeutil.convertToTimestamp(comment.getCreatedAt()))
            .modifiedAt(Timeutil.convertToTimestamp(comment.getModifiedAt()))
            .createdById(comment.getCreatedById())
            .modifiedById(comment.getModifiedById())
            .createdBy(user.getUserName())
            .modifiedBy(user.getUserName()).build();
    }
}
