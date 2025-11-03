package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String name;

    public ScheduleResponse(Long id, String title, String content, String name){
        this.id=id;
        this.title=title;
        this.content=content;
        this.name=name;
    }
}
