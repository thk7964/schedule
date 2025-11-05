package com.example.challengeschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
public class UpdateScheduleResponse extends ScheduleResponse {//일정 수정에 대한 응답 DTO
    public UpdateScheduleResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        super(id, title, content, name, createdAt, modifiedAt);
    }
}
