package com.example.challengeschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponse {
    private final Long id;//일정의 id(기본키)
    private final String title;//일정 제목
    private final String content;//일정 내용
    private final String name;//일정 작성자명
    private final LocalDateTime createdAt;//일정 작성일
    private final LocalDateTime modifiedAt;//일정 수정일

    //생성자
    public ScheduleResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }
}
