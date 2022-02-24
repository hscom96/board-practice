package com.example.backend.controller;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.resolver.CurrentUser;
import com.example.backend.dto.ReactionDto;
import com.example.backend.dto.common.CommonResponse;
import com.example.backend.model.Reaction;
import com.example.backend.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/reaction")
@RestController
public class ReactionController {

    private final ReactionService reactionService;

    @PostMapping("/article/{articleId}")
    public ResponseEntity<CommonResponse<ReactionDto>> login(
        @PathVariable("articleId") Long articleId, @RequestParam("type") String type,
        @CurrentUser Long currentUserId) {

        ReactionDto reactionDto = reactionService.addReaction(articleId, type, currentUserId);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.SUCCESS, reactionDto));
    }
}
