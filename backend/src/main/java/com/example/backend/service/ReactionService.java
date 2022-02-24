package com.example.backend.service;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import com.example.backend.dto.ReactionDto;
import com.example.backend.model.Article;
import com.example.backend.model.Reaction;
import com.example.backend.model.User;
import com.example.backend.repository.ArticleRepository;
import com.example.backend.repository.ReactionRepository;
import com.example.backend.repository.UserRepository;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReactionService {

    private final ReactionRepository reactionRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public ReactionDto addReaction(Long articleId, String type, Long currentUserId){
        User user = userRepository.findById(currentUserId)
            .orElseThrow(() -> {throw new CustomException(ResponseCode.USER_NOT_FOUND);});
        increaseReactionCount(articleId, type);

        // TODO: type 상수화

        Reaction reaction = Reaction.builder()
            .userId(user.getUserId())
            .articleId(articleId)
            .createdById(currentUserId)
            .modifiedById(currentUserId)
            .type(type).build();
        reactionRepository.save(reaction);

        return ReactionDto.of(reaction, user);
    }

    @Transactional
    public void deleteReaction(Long articleId, String type, Long currentUserId){
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> {throw new CustomException(ResponseCode.POST_NOT_FOUND);});
        article.decreaseReaction(type);
        articleRepository.save(article);

        reactionRepository.deleteByTypeAndUserIdAndArticleId(type, currentUserId, articleId);
    }

    private void increaseReactionCount(Long articleId, String type) {
        Article article = articleRepository.findById(articleId)
            .orElseThrow(() -> {throw new CustomException(ResponseCode.POST_NOT_FOUND);});

        article.increaseReaction(type);
        articleRepository.save(article);
    }
}
