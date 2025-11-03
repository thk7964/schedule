package com.example.schedule.service;


import com.example.schedule.dto.*;
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
    public List<GetOneScheduleResponse> getAllSchedule(String name){
        List<Schedule> schedules;
        if (name != null && !name.isBlank()){
            schedules= schedulerepository.findAllByNameOrderByModifiedAtDesc(name);
        }else {
            schedules= schedulerepository.findAllByOrderByModifiedAtDesc();
        }

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
    //일정 수정
    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request){
        Schedule schedule=  schedulerepository.findById(scheduleId).orElseThrow(
                ()-> new IllegalStateException("존재하지 않는 유저 입니다.")
        );

        if (!schedule.getPassword().equals(request.getPassword())){
            throw new IllegalArgumentException("비밀번호가 일치 하지 않습니다.");
        }
        schedule.update(
                request.getTitle(),
                request.getName()
        );
        return new UpdateScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }
    //일정 삭제
    @Transactional
    public void delete(Long scheduleId){
        boolean existence = schedulerepository.existsById(scheduleId);
        if(!existence){
            throw new IllegalStateException("존재하지 않는 유저입니다.");
        }
        schedulerepository.deleteById(scheduleId);
    }
}
