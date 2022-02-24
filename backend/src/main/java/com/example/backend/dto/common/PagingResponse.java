package com.example.backend.dto.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PagingResponse<T> {

    int currentPage;
    int totalPage;
    List<T> content;

    public static <T> PagingResponse<T> of(Page<T> pageable){
        return new PagingResponse<>(pageable.getNumber(), pageable.getTotalPages(), pageable.getContent());
    }
}
