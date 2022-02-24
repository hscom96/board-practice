package com.example.backend.dto.request;

import com.example.backend.model.Article;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleWriteRequest {

    @NotBlank(message = "title is empty")
    private String title;

    @NotBlank(message = "content is empty")
    private String content;

    public Article
    toEntity(Long currentUserId) {
        return Article.builder()
            .viewCnt(0)
            .upsetCnt(0)
            .sadCnt(0)
            .likeCnt(0)
            .title(title)
            .content(content)
            .createdById(currentUserId)
            .modifiedById(currentUserId)
            .build();
    }
}
