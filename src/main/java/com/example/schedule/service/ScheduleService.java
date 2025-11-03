package com.example.schedule.service;


import com.example.schedule.dto.CreateScheduleRequest;
import com.example.schedule.dto.CreateScheduleResponse;
import com.example.schedule.dto.GetOneScheduleResponse;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.Schedulerepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final Schedulerepository schedulerepository;

    //일정 생성
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request){
        Schedule schedule = new Schedule(request.getTitle(),request.getContent(),request.getName(),request.getPassword());
        Schedule saveSchedule = schedulerepository.save(schedule);

        return new CreateScheduleResponse(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getName(),
                saveSchedule.getCreatedAt(),
                saveSchedule.getModifiedAt()
        );

    }
    //일정 단 건 조회
    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOneSchedule(Long scheduleId){
        Schedule schedule = schedulerepository.findById(scheduleId).orElseThrow(
                ()-> new IllegalStateException("존재하지 않는 유저 입니다.")
        );
        return new GetOneScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // 일정 전체 조회
    @Transactional(readOnly = true)
    public List<GetOneScheduleResponse> getAllSchedule(){
        List<Schedule> schedules = schedulerepository.findAll();
        List<GetOneScheduleResponse> dtos = new ArrayList<>();
        for (Schedule schedule : schedules){
            GetOneScheduleResponse dto =new GetOneScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
