package com.example.backend.dto;

import com.example.backend.common.util.Timeutil;
import com.example.backend.model.Article;
import com.example.backend.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

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

    private long createdAt;

    private long modifiedAt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String modifiedBy;

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
            .createdAt(Timeutil.convertToTimestamp(article.getCreatedAt()))
            .modifiedAt(Timeutil.convertToTimestamp(article.getModifiedAt()))
            .commentCnt(article.getCommentCnt()).build();
    }

    public static ArticleDto of(Article article, User user) {
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
            .createdAt(Timeutil.convertToTimestamp(article.getCreatedAt()))
            .modifiedAt(Timeutil.convertToTimestamp(article.getModifiedAt()))
            .commentCnt(article.getCommentCnt())
            .createdBy(user.getUserName())
            .modifiedBy(user.getUserName()).build();
    }
}

