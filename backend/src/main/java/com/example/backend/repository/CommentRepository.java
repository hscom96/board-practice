package com.example.backend.repository;

import com.example.backend.model.Comment;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByArticleId(Long articleId, Pageable pageable);
}
