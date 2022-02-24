package com.example.backend.service;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import com.example.backend.dto.ReactionDto;
import com.example.backend.model.Reaction;
import com.example.backend.model.User;
import com.example.backend.repository.ReactionRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReactionService {

    private final ReactionRepository reactionRepository;
    private final UserRepository userRepository;

    public ReactionDto addReaction(Long articleId, String type, Long currentUserId){
        User user = userRepository.findById(currentUserId)
            .orElseThrow(() -> {throw new CustomException(ResponseCode.USER_NOT_FOUND);});

        // TODO: type 상수화
        // TODO: article 존재여부 검증

        Reaction reaction = Reaction.builder()
            .userId(user.getUserId())
            .articleId(articleId)
            .createdBy(user.getUserName())
            .type(type).build();

        reactionRepository.save(reaction);

        return ReactionDto.of(reaction, user);
    }
}
