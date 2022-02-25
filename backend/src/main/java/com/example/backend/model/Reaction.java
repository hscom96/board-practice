package com.example.backend.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@IdClass(ReactionId.class)
@Entity
public class Reaction extends AuditProperties {

    @Id
    @Column(name = "type")
    private String type;

    @Id
    @Column(name = "article_id")
    private Long articleId;

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Builder
    public Reaction(LocalDateTime createdAt, LocalDateTime modifiedAt,
        Long createdById, Long modifiedById, String type, Long articleId, Long userId) {
        super(createdAt, modifiedAt, createdById, modifiedById);
        this.type = type;
        this.articleId = articleId;
        this.userId = userId;
    }
}


