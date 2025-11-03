package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class CreateScheduleRequest extends ScheduleRequest {
    private String content;
    private String password;
}
