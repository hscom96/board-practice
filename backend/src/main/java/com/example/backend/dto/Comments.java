package com.example.backend.dto;

import com.example.backend.model.Comment;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Comments {
    private  List<Comment> comments;
}
