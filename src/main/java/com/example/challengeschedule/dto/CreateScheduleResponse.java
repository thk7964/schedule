package com.example.challengeschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse extends ScheduleResponse {//일정 생성에 대한 응답 DTO

    public CreateScheduleResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        super(id, title, content, name, createdAt, modifiedAt);

    }
}
