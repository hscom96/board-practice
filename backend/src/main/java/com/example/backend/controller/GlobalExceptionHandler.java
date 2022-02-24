package com.example.backend.controller;

import com.example.backend.common.constants.ResponseCode;
import com.example.backend.common.exception.CustomException;
import com.example.backend.dto.common.CommonResponse;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 비즈니스 로직 exception 처리
     */
    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<CommonResponse<Object>> handleCustomException(CustomException ex) {
        ResponseCode responseCode = ex.getResponseCode();
        log.info("--- [{}] 시스템 오류 감지 : {}", responseCode.getCode(), responseCode.getMessage(), ex);
        return ResponseEntity.ok(new CommonResponse<>(responseCode));
    }

    /**
     * 파라미터 유효성관련 exception 처리
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<CommonResponse<Object>> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {
        List<String> fieldErrorMessage = getFieldErrorMessage(e.getFieldErrors());
        CommonResponse<Object> response = new CommonResponse<>(ResponseCode.PARAM_INVALID,
            fieldErrorMessage);
        log.error("Argument is wrong: {}", response.getData());
        return ResponseEntity.ok(response);
    }

    /**
     * 알 수 없는 exception 처리
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleException(Exception ex) {
        log.error("--- 알 수 없는 오류 감지.  ", ex);
        return ResponseEntity.ok(new CommonResponse<>(ResponseCode.ETC));
    }

    private List<String> getFieldErrorMessage(List<FieldError> fieldErrors) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : fieldErrors) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        return errors;
    }
}
