package com.example.backend.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends AuditProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long commentId;

    @Setter
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "article_id", nullable = false)
    private Long articleId;

    @Column(name = "parent_id", nullable = false)
    private Long parentId;

    @Builder
    public Comment(LocalDateTime createdAt, LocalDateTime modifiedAt, Long commentId, String content,
        Long articleId, Long parentId, Long createdById, Long modifiedById) {
        super(createdAt, modifiedAt, createdById, modifiedById);
        this.commentId = commentId;
        this.content = content;
        this.articleId = articleId;
        this.parentId = parentId;
    }
}
