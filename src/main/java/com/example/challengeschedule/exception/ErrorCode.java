package com.example.challengeschedule.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "SCH-001", "존재하지 않는 일정입니다."),
    INVALID_SCHEDULE_PASSWORD(HttpStatus.UNAUTHORIZED, "SCH-002", "비밀번호가 일치하지 않습니다."),
    COMMENT_LIMIT_EXCEEDED(HttpStatus.BAD_REQUEST, "SCH-003", "댓글은 최대 10개까지만 작성할 수 있습니다.");

    private final HttpStatus httpStatus;	// HttpStatus
    private final String code;				// SCH-001
    private final String message;			// 설명

}