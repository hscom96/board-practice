package com.example.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(ReactionId.class)
@Entity
public class Reaction extends AuditProperties {

    @Id
    @Column(name = "type")
    private String type;

    @Id
    @Column(name = "article_id")
    private String articleId;

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "created_by")
    private String createdBy;
}
