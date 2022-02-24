package com.example.backend.controller;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.resolver.CurrentUser;
import com.example.backend.dto.CommentListResponseDto;
import com.example.backend.dto.CommentResponseDto;
import com.example.backend.dto.common.CommonResponse;
import com.example.backend.dto.request.CommentCreateRequest;
import com.example.backend.dto.request.CommentUpdateRequest;
import com.example.backend.service.CommentService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/article/")
@RestController
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{articleId}/comment")
    public ResponseEntity<CommonResponse<CommentListResponseDto>> read(@PathVariable("articleId") Long articleId,
        @RequestParam("page") int pageNo, @RequestParam("size") int pageSize) {

        CommentListResponseDto commentListResponseDto = commentService.read(articleId, pageNo, pageSize);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, commentListResponseDto));
    }

    @PostMapping("/{articleId}/comment")
    public ResponseEntity<CommonResponse<CommentResponseDto>> create(@RequestBody @Valid CommentCreateRequest commentCreateRequest,
        @PathVariable("articleId") Long articleId, @CurrentUser Long currentUserId) {

        CommentResponseDto commentResponseDto = commentService.create(commentCreateRequest, articleId, currentUserId);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, commentResponseDto));
    }

    @PutMapping("/{articleId}/comment/{commentId}")
    public ResponseEntity<CommonResponse<CommentResponseDto>> update(@RequestBody @Valid CommentUpdateRequest commentUpdateRequest,
        @PathVariable("articleId") Long articleId, @PathVariable("commentId") Long commentId, @CurrentUser Long currentUserId) {

        CommentResponseDto commentResponseDto = commentService.update(commentUpdateRequest, articleId,
            currentUserId, commentId);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, commentResponseDto));
    }

    @DeleteMapping("/{articleId}/comment/{commentId}")
    public ResponseEntity<CommonResponse<HttpStatus>> delete(@PathVariable("articleId") Long articleId,
        @PathVariable("commentId") Long commentId) {

        HttpStatus httpStatus = commentService.delete(articleId, commentId);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, httpStatus));
    }
}
