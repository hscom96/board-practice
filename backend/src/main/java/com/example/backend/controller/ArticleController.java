package com.example.backend.controller;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.resolver.CurrentUser;
import com.example.backend.dto.ArticleDto;
import com.example.backend.dto.common.CommonResponse;
import com.example.backend.dto.request.ArticleUpdateRequest;
import com.example.backend.dto.request.ArticleWriteRequest;
import com.example.backend.service.ArticleService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/article")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<CommonResponse<ArticleDto>> write(
        @RequestBody @Valid ArticleWriteRequest articleWriteRequest,
        @CurrentUser Long currentUserId) {
        ArticleDto articleDto = articleService.write(articleWriteRequest, currentUserId);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, articleDto));
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<CommonResponse<ArticleDto>> update(
        @PathVariable("articleId") Long articleId,
        @RequestBody @Valid ArticleUpdateRequest articleUpdateRequest,
        @CurrentUser Long currentUserId) {
        ArticleDto articleDto = articleService.update(articleId, articleUpdateRequest,
            currentUserId);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, articleDto));
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<CommonResponse<ArticleDto>> getArticle(
        @PathVariable("articleId") Long articleId) {
        ArticleDto articleDto = articleService.getArticle(articleId);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, articleDto));
    }

    @GetMapping
    public ResponseEntity<CommonResponse<?>> getArticles(@RequestParam("page") int page,
        @RequestParam("size") int size) {
        var articles = articleService.getArticles(page, size);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, articles));
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<CommonResponse<ArticleDto>> delete(
        @PathVariable("articleId") Long articleId) {
        articleService.delete(articleId);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS));
    }
}
