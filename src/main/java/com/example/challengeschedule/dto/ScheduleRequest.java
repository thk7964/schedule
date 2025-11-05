package com.example.challengeschedule.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
public class ScheduleRequest {
    @Size(max=30)//일정 제목 최대 30글자까지 제한
    @NotBlank(message= "일정 제목은 필수 입력 값입니다.")//한 글자라도 입력이 안되면 "일정 제목은 필수 입력 값입니다."반환(필수값 설정)
    private String title;//일정 제목
    @NotBlank(message = "작성자명은 필수 입력 값입니다.")//한 글자라도 입력이 안되면 "작성자명은 필수 입력 값입니다."반환(필수값 설정)
    private String name;//일정 이름
}
