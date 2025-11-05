package com.example.challengeschedule.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
public class CreateScheduleRequest extends ScheduleRequest {
    @Size(max=200)//일정 내용 최대 200글자까지 제한
    @NotBlank(message="일정 내용은 필수 입력 값입니다.")//한 글자라도 입력이 안되면 "일정 내용은 필수 입력 값입니다."반환(필수값 설정)
    private String content;//일정 내용
    @NotBlank(message="비밀번호는 필수 입력 값입니다.")//한 글자라도 입력이 안되면 "일정 비밀번호는 필수 입력 값입니다."반환(필수값 설정)
    private String password;//일정 비밀번호
}
