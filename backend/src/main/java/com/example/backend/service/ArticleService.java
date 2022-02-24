package com.example.backend.service;

import com.example.backend.dto.ArticleDto;
import com.example.backend.dto.request.ArticleWriteRequest;
import com.example.backend.model.Article;
import com.example.backend.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleDto write(ArticleWriteRequest articleWriteRequest, Long currentUserId) {
        Article article = articleRepository.save(articleWriteRequest.toEntity(currentUserId));
        return ArticleDto.of(article);
    }
}
