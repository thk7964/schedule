package com.example.schedule.controller;

import com.example.schedule.dto.*;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedule")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@RequestBody CreateScheduleRequest request) {
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedule/{scheduleId}")
    public ResponseEntity<GetOneScheduleResponse> getOneScheduleResponse(@PathVariable Long scheduleId) {
        GetOneScheduleResponse result = scheduleService.getOneSchedule(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<GetOneScheduleResponse>> getAllSchedule(@RequestParam(required = false) String name) {
       List<GetOneScheduleResponse> result = scheduleService.getAllSchedule(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping("/schedule/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> update(@PathVariable Long scheduleId, @RequestBody UpdateScheduleRequest request) {
        UpdateScheduleResponse result = scheduleService.update(scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/schedule/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
