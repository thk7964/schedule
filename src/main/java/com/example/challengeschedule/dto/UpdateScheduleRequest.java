package com.example.challengeschedule.dto;

import lombok.Getter;

@Getter
public class UpdateScheduleRequest extends ScheduleRequest {//일정 수정시 사용되는 DTO
    private String password;//일정 수정시 필요한 비밀번호
}
