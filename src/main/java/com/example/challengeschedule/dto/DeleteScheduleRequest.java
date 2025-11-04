package com.example.challengeschedule.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeleteScheduleRequest {
    @NotBlank(message = "비밀번호는 필수 입력값입니다.")
    private String password;
}
