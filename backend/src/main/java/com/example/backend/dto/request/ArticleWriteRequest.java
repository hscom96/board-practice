package com.example.backend.dto.request;

import com.example.backend.model.Article;
import com.example.backend.model.User;
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

    private String image;

    @NotBlank(message = "label is empty")
    private String label;

    public Article
    toEntity(Long currentUserId, User user) {
        return Article.builder()
            .viewCnt(0)
            .upsetCnt(0)
            .sadCnt(0)
            .likeCnt(0)
            .title(title)
            .content(content)
            .image(image)
            .label(label)
            .createdById(currentUserId)
            .modifiedById(currentUserId)
            .createdBy(user.getUserName())
            .modifiedBy(user.getUserName())
            .build();
    }

}
