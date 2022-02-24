package com.example.backend.service;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import com.example.backend.dto.CommentListDto;
import com.example.backend.dto.CommentDto;
import com.example.backend.dto.Comments;
import com.example.backend.dto.request.CommentCreateRequest;
import com.example.backend.dto.request.CommentUpdateRequest;
import com.example.backend.model.Article;
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

    private static final int COUNT = 1;

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public CommentListDto read(Long articleId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Comments comments = getCommentsBy(articleId, pageable);

        return CommentListDto.of(comments, pageable);
    }

    public CommentDto create(CommentCreateRequest commentCreateRequest, Long articleId, Long currentUserId) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.POST_NOT_FOUND);
            });

        Comment comment = commentCreateRequest.toEntity(articleId, currentUserId);
        commentRepository.save(comment);

        article.setCommentCnt(article.getCommentCnt() + COUNT);
        articleRepository.save(article);

        return CommentDto.from(comment);
    }

    public CommentDto update(CommentUpdateRequest commentUpdateRequest, Long articleId, Long currentUserId, Long commentId) {
        articleRepository.findById(articleId)
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.POST_NOT_FOUND);
            });
        validateAuth(commentId, currentUserId);

        Comment updateComment = commentRepository.findById(commentId)
            .orElseThrow(() -> {throw new CustomException(ResponseCode.COMMENT_NOT_FOUND);});

        updateComment.setContent(commentUpdateRequest.getContent());
        commentRepository.save(updateComment);

        return CommentDto.from(updateComment);
    }

    public HttpStatus delete(Long articleId, Long commentId) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> {
                throw new CustomException(ResponseCode.POST_NOT_FOUND);
            });

        if (article.getCommentCnt() < 0) {
            throw new CustomException(ResponseCode.COMMENT_NOT_FOUND);
        }

        Comment deleteComment = commentRepository.findById(commentId)
            .orElseThrow(() -> {throw new CustomException(ResponseCode.COMMENT_NOT_FOUND);});

        commentRepository.deleteById(deleteComment.getCommentId());

        article.setCommentCnt(article.getCommentCnt() - COUNT);
        articleRepository.save(article);

        return HttpStatus.OK;
    }

    private Comments getCommentsBy(Long articleId, Pageable pageable) {
        List<Comment> comments = commentRepository.findByArticleId(articleId, pageable);

        return Comments.builder()
            .comments(comments).build();
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
