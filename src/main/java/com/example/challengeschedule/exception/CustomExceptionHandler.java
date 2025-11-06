package com.example.challengeschedule.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//모든 컨드롤러에서 발생하는 예외를 한 곳에서 모아 처리한다.
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)//CustomException이 발생했을 때 메서드 실행
    protected ResponseEntity<ErrorResponseEntity> handleCustomException(CustomException e){
        return ErrorResponseEntity.toResponseEntity(e.getErrorCode());//사용자에게 응답
    }
}