package com.example.challengeschedule.controller;

import com.example.challengeschedule.dto.*;
import com.example.challengeschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController//Spring에서 Controller를 지정
@RequiredArgsConstructor//final 필드에 대한 생성자를 자동 생성
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정 생성
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponse> createSchedule(@Valid @RequestBody CreateScheduleRequest request) {
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);//생성된 일정 정보와 201 상태코드 반환
    }

    //단건 조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<GetOneScheduleResponse> getOneScheduleResponse(@PathVariable Long scheduleId) {
        GetOneScheduleResponse result = scheduleService.getOneSchedule(scheduleId);
        return ResponseEntity.status(HttpStatus.OK).body(result);//단건 조회 정보와 200 상태코드 반환
    }

    //전체 조회
    @GetMapping("/schedules")
    public ResponseEntity<List<GetOneScheduleResponse>> getAllSchedule(@RequestParam(required = false) String name) {
        List<GetOneScheduleResponse> result = scheduleService.getAllSchedule(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);//전체 조회 정보와 200 상태코드 반환
    }

    //일정 수정
    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponse> update(@Valid @PathVariable Long scheduleId, @RequestBody UpdateScheduleRequest request) {
        UpdateScheduleResponse result = scheduleService.update(scheduleId, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);//수정된 일정 정보와 200 상태코드 반환
    }

    //알정 삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId, @Valid @RequestBody DeleteScheduleRequest request) {
        scheduleService.delete(scheduleId, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//삭제 성공시 204 상태코드 반환
    }

}
