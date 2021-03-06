package com.example.backend.service;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import com.example.backend.dto.ArticleDto;
import com.example.backend.dto.common.PagingResponse;
import com.example.backend.dto.request.ArticleUpdateRequest;
import com.example.backend.dto.request.ArticleWriteRequest;
import com.example.backend.model.Article;
import com.example.backend.model.User;
import com.example.backend.repository.ArticleRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleDto write(ArticleWriteRequest articleWriteRequest, Long currentUserId) {
        User user = userRepository.findById(currentUserId)
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.USER_NOT_FOUND);
            });

        Article article = articleRepository.save(articleWriteRequest.toEntity(currentUserId, user));
        return ArticleDto.of(article);
    }

    public ArticleDto update(Long articleId, ArticleUpdateRequest articleUpdateRequest,
        Long currentUserId) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.POST_NOT_FOUND);
            });
        validateUserId(currentUserId, article);
        User user = userRepository.findById(article.getCreatedById())
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.USER_NOT_FOUND);
            });
        article.update(articleUpdateRequest.toEntity(currentUserId,user));
        Article updatedArticle = articleRepository.save(article);
        return ArticleDto.of(updatedArticle);
    }

    private void validateUserId(Long currentUserId, Article article) {
        if (currentUserId != (article.getCreatedById())) {
            throw new CustomException(ResponseCode.USER_NOT_GRANTED);
        }
    }

    public ArticleDto getArticle(Long articleId) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.POST_NOT_FOUND);
            });
        article.increaseViewCnt(); articleRepository.save(article);

        return ArticleDto.of(article);
    }

    public PagingResponse<ArticleDto> getArticles(int page, int size) {
        Page<ArticleDto> articles = articleRepository.findAll(PageRequest.of(page, size))
            .map(ArticleDto::of);
        return PagingResponse.of(articles);
    }

    public void delete(Long articleId) {
        articleRepository.findById(articleId)
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.POST_NOT_FOUND);
            });
        articleRepository.deleteById(articleId);
    }

}
