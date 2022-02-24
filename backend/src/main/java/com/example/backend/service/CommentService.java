package com.example.backend.service;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import com.example.backend.dto.CommentListDto;
import com.example.backend.dto.CommentDto;
import com.example.backend.dto.Comments;
import com.example.backend.dto.request.CommentCreateRequest;
import com.example.backend.dto.request.CommentUpdateRequest;
import com.example.backend.model.Comment;
import com.example.backend.repository.ArticleRepository;
import com.example.backend.repository.CommentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public CommentListDto read(Long articleId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Comments comments = getCommentsBy(articleId, pageable);

        return CommentListDto.of(comments, pageable);
    }

    public CommentDto create(CommentCreateRequest commentCreateRequest, Long articleId, Long currentUserId) {
        Comment comment = commentCreateRequest.toEntity(articleId, currentUserId);
        commentRepository.save(comment);

        return CommentDto.from(comment);
    }

    public CommentDto update(CommentUpdateRequest commentUpdateRequest, Long articleId, Long currentUserId, Long commentId) {
        validateArticle(articleId);
        validateAuth(commentId, currentUserId);

        Comment updateComment = commentRepository.findById(commentId)
            .orElseThrow(() -> {throw new CustomException(ResponseCode.COMMENT_NOT_FOUND);});

        updateComment.setContent(commentUpdateRequest.getContent());
        commentRepository.save(updateComment);

        return CommentDto.from(updateComment);
    }

    public HttpStatus delete(Long articleId, Long commentId) {
        validateArticle(articleId);

        Comment deleteComment = commentRepository.findById(commentId)
            .orElseThrow(() -> {throw new CustomException(ResponseCode.COMMENT_NOT_FOUND);});

        commentRepository.deleteById(deleteComment.getCommentId());

        return HttpStatus.OK;
    }

    private Comments getCommentsBy(Long articleId, Pageable pageable) {
        List<Comment> comments = commentRepository.findByArticleId(articleId, pageable);

        return Comments.builder()
            .comments(comments).build();
    }

    private void validateArticle(Long articleId) {
        articleRepository.findById(articleId)
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.POST_NOT_FOUND);
            });
    }

    private void validateAuth(Long commentId, Long currentUserId) {
        Comment comment = commentRepository.findById(commentId)
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.COMMENT_NOT_FOUND);
            });

        if (comment.getCreatedById() != currentUserId) {
            throw new CustomException(ResponseCode.USER_ACCESS_ERROR);
        }
    }
}
