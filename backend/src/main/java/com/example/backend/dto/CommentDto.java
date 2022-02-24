package com.example.backend.dto;

import com.example.backend.common.util.Timeutil;
import com.example.backend.dto.common.CommentProperties;
import com.example.backend.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CommentDto extends CommentProperties {

    private Long commentId;
    private Long parentId;
    private Long articleId;
    private String content;

    private Long createdAt;
    private Long createdById;

    private Long modifiedAt;
    private Long modifiedById;

    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
            .commentId(comment.getCommentId())
            .parentId(comment.getParentId())
            .articleId(comment.getArticleId())
            .content(comment.getContent())
            .createdAt(Timeutil.convertToTimestamp(comment.getCreatedAt()))
            .modifiedAt(Timeutil.convertToTimestamp(comment.getModifiedAt()))
            .createdById(comment.getCreatedById())
            .modifiedById(comment.getModifiedById()).build();
    }
}
