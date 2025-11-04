package com.example.challengeschedule.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class CreateScheduleRequest extends ScheduleRequest {
    @Size(max=200)
    @NotBlank(message="일정 내용은 필수 입력 값입니다.")
    private String content;
    @NotBlank(message="비밀번호는 필수 입력 값입니다.")
    private String password;
}
