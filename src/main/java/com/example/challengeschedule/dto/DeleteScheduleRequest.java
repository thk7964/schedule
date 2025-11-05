package com.example.challengeschedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
public class DeleteScheduleRequest {
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")//한 글자라도 입력이 안되면 "비밀번호는 필수 입력값입니다."반환(필수값 설정)
    private String password;//일정 비밀번호
}
