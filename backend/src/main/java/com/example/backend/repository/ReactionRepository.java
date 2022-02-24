package com.example.backend.repository;

import com.example.backend.model.Reaction;
import com.example.backend.model.ReactionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<Reaction, ReactionId> {

    void deleteByTypeAndUserIdAndArticleId(String type, Long userId, Long articleId);
}
