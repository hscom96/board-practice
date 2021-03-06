package com.example.backend.common.constants;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(200, "success"),

    /* 기타 오류 메세지 정의 */
    ETC(1000, "알 수 없는 오류입니다."),
    PARAM_INVALID(1001, "올바르지 않은 파라미터입니다."),
    /* 기타 오류 메세지 정의 끝*/

    /* 회원 관련 오류 정의 */
    USER_NOT_FOUND(2000, "해당 회원을 찾을 수 없습니다."),
    PWD_FORM_ERROR(2001, "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다."),
    USER_ID_DUPLICATE(2002, "이미 존재하는 회원 아이디입니다."),
    /* 회원 관련 오류 정의 끝*/

    /* 댓글 관련 오류 정의 */
    COMMENT_NOT_FOUND(3000, "해당 댓글을 찾을 수 없습니다."),
    USER_ACCESS_ERROR(3001, "해당 댓글을 작성한 회원만 수정할 수 있습니다."),
    /* 댓글 관련 오류 정의 끝*/

    /* 게시글 관련 오류 정의 */
    POST_NOT_FOUND(4000, "해당 게시글을 찾을 수 없습니다."),
    USER_NOT_GRANTED (4001, "권한이 없습니다.");
    /* 게시글 관련 오류 정의 끝*/


    private final int code;

    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
