package com.example.backend.dto;

import com.example.backend.model.Article;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ArticleDto {

    private Long articleId;

    private String title;

    private String content;

    private String image;

    private Long createdById;

    private Long modifiedById;

    private int likeCnt;

    private int sadCnt;

    private int upsetCnt;

    private int viewCnt;

    private String label;

    private int commentCnt;

    public static ArticleDto of(Article article) {
        return ArticleDto.builder()
            .articleId(article.getArticleId())
            .title(article.getTitle())
            .content(article.getContent())
            .image(article.getImage())
            .createdById(article.getCreatedById())
            .modifiedById(article.getModifiedById())
            .likeCnt(article.getLikeCnt())
            .sadCnt(article.getSadCnt())
            .upsetCnt(article.getUpsetCnt())
            .viewCnt(article.getViewCnt())
            .label(article.getLabel())
            .commentCnt(article.getCommentCnt()).build();
    }
}
