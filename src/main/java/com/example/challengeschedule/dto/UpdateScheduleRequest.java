package com.example.challengeschedule.dto;

import lombok.Getter;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
public class UpdateScheduleRequest extends ScheduleRequest {//일정 수정시 사용되는 DTO
    private String password;//일정 수정시 필요한 비밀번호
}
