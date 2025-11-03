package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class GetOneScheduleResponse extends ScheduleResponse{

    public GetOneScheduleResponse(Long id, String title, String content, String name) {
        super(id, title, content, name);
    }
}
