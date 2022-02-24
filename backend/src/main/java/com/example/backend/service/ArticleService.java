package com.example.backend.service;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import com.example.backend.dto.ArticleDto;
import com.example.backend.dto.request.ArticleUpdateRequest;
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

    public ArticleDto update(Long articleId, ArticleUpdateRequest articleWriteRequest,
        Long currentUserId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> {
            throw new CustomException(ResponseCode.POST_NOT_FOUND);
        });
        if (!currentUserId.equals(article.getArticleId())) {
            throw new CustomException(ResponseCode.USER_NOT_GRANTED);
        }
        article.update(articleWriteRequest.toEntity(currentUserId));
        Article updatedArticle = articleRepository.save(article);
        return ArticleDto.of(updatedArticle);
    }

}
