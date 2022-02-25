package com.example.backend.dto.request;

import com.example.backend.model.Article;
import com.example.backend.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleUpdateRequest {

    private String title;

    private String content;

    private String image;

    public Article toEntity(Long currentUserId, User user){
        return Article.builder()
            .modifiedById(currentUserId)
            .title(title)
            .content(content)
            .image(image)
            .modifiedBy(user.getUserName())
            .build();
    }
}
