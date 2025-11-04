package com.example.challengeschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GetOneScheduleResponse extends ScheduleResponse {
    private final List<CommentResponse> components;

    public GetOneScheduleResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt, List<CommentResponse> components) {
        super(id, title, content, name, createdAt, modifiedAt);
        this.components=components;
    }

    public GetOneScheduleResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt){
        super(id, title, content, name, createdAt, modifiedAt);
        this.components=null;
    }
}
