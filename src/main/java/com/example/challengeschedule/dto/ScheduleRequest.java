package com.example.challengeschedule.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class ScheduleRequest {
    @Size(max=30)
    @NotBlank(message= "일정 제목은 필수 입력 값입니다.")
    private String title;
    @NotBlank(message = "작성자명은 필수 입력 값입니다.")
    private String name;
}
