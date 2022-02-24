package com.example.backend.service;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import com.example.backend.dto.ArticleDto;
import com.example.backend.dto.common.PagingResponse;
import com.example.backend.dto.request.ArticleWriteRequest;
import com.example.backend.model.Article;
import com.example.backend.repository.ArticleRepository;
import java.awt.print.Pageable;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleDto write(ArticleWriteRequest articleWriteRequest, Long currentUserId) {
        Article article = articleRepository.save(articleWriteRequest.toEntity(currentUserId));
        return ArticleDto.of(article);
    }

    public ArticleDto getArticle(Long articleId){
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> {throw new CustomException(ResponseCode.POST_NOT_FOUND);});
        return ArticleDto.of(article);
    }

    public PagingResponse<ArticleDto> getArticles(int page, int size){
        Page<ArticleDto> articles = articleRepository.findAll(PageRequest.of(page, size))
            .map(ArticleDto::of);

        return PagingResponse.of(articles);
    }
}
