package com.example.challengeschedule.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
@AllArgsConstructor//모든 필드를 매개변수로 받는 생성자를 자동생성
public class CustomException extends RuntimeException{
    private final ErrorCode errorCode;
}
