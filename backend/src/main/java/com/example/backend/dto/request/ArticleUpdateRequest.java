package com.example.backend.dto.request;

import com.example.backend.model.Article;

public class ArticleUpdateRequest {

    private String title;

    private String content;

    private String image;

    public Article toEntity(Long currentUserId){
        return Article.builder()
            .modifiedById(currentUserId)
            .title(title)
            .content(content)
            .image(image)
            .build();
    }
}
