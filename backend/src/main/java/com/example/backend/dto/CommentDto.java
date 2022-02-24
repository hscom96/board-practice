package com.example.backend.dto;

import com.example.backend.dto.common.CommentProperties;
import com.example.backend.model.Comment;
import com.example.backend.model.User;
import java.time.LocalDateTime;
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

    private LocalDateTime createdAt;
    private Long createdById;

    private LocalDateTime modifiedAt;
    private Long modifiedById;

    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
            .commentId(comment.getCommentId())
            .parentId(comment.getParentId())
            .articleId(comment.getArticleId())
            .content(comment.getContent())
            .createdAt(comment.getCreatedAt())
            .createdById(comment.getCreatedById())
            .modifiedAt(comment.getModifiedAt())
            .modifiedById(comment.getModifiedById()).build();
    }

    public static UserDto from(User user){
        return UserDto.builder()
            .userId(user.getUserId())
            .name(user.getName())
            .userName(user.getUserName()).build();
    }
}
