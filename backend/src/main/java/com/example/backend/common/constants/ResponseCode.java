package com.example.backend.common.constants;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(200, "success"),

    /* 기타 오류 메세지 정의 */
    ETC(1000, "알 수 없는 오류입니다."),
    PARAM_INVALID(1001, "올바르지 않은 파라미터입니다.");
    /* 기타 오류 메세지 정의 끝*/

    private final int code;

    private final String message;

    ResponseCode(int code, String message){
        this.code = code;
        this.message = message;
    }
}
