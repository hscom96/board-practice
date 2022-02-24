package com.example.backend.model;

import java.io.Serializable;
import java.util.Objects;

public class ReactionId implements Serializable {

    private String type;

    private Long articleId;

    private Long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReactionId commentId = (ReactionId) o;
        return Objects.equals(type, commentId.type) && Objects.equals(articleId,
            commentId.articleId) && Objects.equals(userId, commentId.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, articleId, userId);
    }
}
