package com.example.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse extends ScheduleResponse {
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateScheduleResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        super(id, title, content, name);
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
