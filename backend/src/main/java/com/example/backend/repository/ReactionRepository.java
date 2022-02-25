package com.example.backend.repository;

import com.example.backend.model.Reaction;
import com.example.backend.model.ReactionId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<Reaction, ReactionId> {

    void deleteByTypeAndUserIdAndArticleId(String type, long userId, long articleId);
    List<Reaction> findAllByArticleIdAndUserId(long articleId, long userId);
}
