package com.example.challengeschedule.service;


import com.example.challengeschedule.dto.*;
import com.example.challengeschedule.entity.Comment;
import com.example.challengeschedule.entity.Schedule;
import com.example.challengeschedule.exception.CustomException;
import com.example.challengeschedule.exception.ErrorCode;
import com.example.challengeschedule.repository.CommentRepository;
import com.example.challengeschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor//final 필드에 대한 생성자를 자동 생성
public class ScheduleService {

    private final ScheduleRepository schedulerepository;
    private final CommentRepository commentRepository;
    //일정 생성
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request){
        //요청값을 기반으로 일정 엔티티 생성
        Schedule schedule = new Schedule(request.getTitle(),request.getContent(),request.getName(),request.getPassword());
        Schedule saveSchedule = schedulerepository.save(schedule);//DB에 저장

        return new CreateScheduleResponse(
                saveSchedule.getId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent(),
                saveSchedule.getName(),
                saveSchedule.getCreatedAt(),
                saveSchedule.getModifiedAt()
        );

    }
    //일정 단건 조회
    @Transactional(readOnly = true)
    public GetOneScheduleResponse getOneSchedule(Long scheduleId){
        //일정이 없으면 예외 발생
        Schedule schedule = schedulerepository.findById(scheduleId).orElseThrow(
                ()-> new CustomException(ErrorCode.SCHEDULE_NOT_FOUND)
        );
        List<Comment> comments= commentRepository.findAllByScheduleId(scheduleId);
        List<CommentResponse> commentResponses=comments.stream()
                .map(comment -> new CommentResponse(
                        comment.getCommentId(),
                        comment.getCommentContent(),
                        comment.getCommentName(),
                        comment.getCreatedAt(),
                        comment.getModifiedAt()
                ))
                .toList();
        if(!commentResponses.isEmpty()){//댓글이 하나 이상 있을 때 댓글을 포함해서 반환
            return new GetOneScheduleResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt(),
                    commentResponses
            );
        }
        return new GetOneScheduleResponse(//댓글이 없을 경우 댓글 제외하고 반환
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
        //name이 null인지 공백인지 필터링
        if (name != null && !name.isBlank()){
            //작성자 명 기준으로 조회 (수정일 기준 내림차순)
            schedules= schedulerepository.findAllByNameOrderByModifiedAtDesc(name);
        }else {
            //작성자 명이 없을 경우 전체 조회 (수정일 기준 내림차순)
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
        //수정할 일정이 없으면 예외 발생
        Schedule schedule=  schedulerepository.findById(scheduleId).orElseThrow(
                ()-> new CustomException(ErrorCode.SCHEDULE_NOT_FOUND)
        );
        //비밀번호가 일치 하지 않으면 예외 발생
        if (!schedule.getPassword().equals(request.getPassword())){
            throw new CustomException(ErrorCode.INVALID_SCHEDULE_PASSWORD);
        }
        //제목과 작성자명 업데이트
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
    public void delete(Long scheduleId, DeleteScheduleRequest request){
        //해당 일정 존재유무 확인 없으면 예외 발생
        Schedule schedule=  schedulerepository.findById(scheduleId).orElseThrow(
                ()-> new CustomException(ErrorCode.SCHEDULE_NOT_FOUND)
        );
        //비밀번호가 일치 하지 않으면 예외 발생
        if (!schedule.getPassword().equals(request.getPassword())){
            throw new CustomException(ErrorCode.INVALID_SCHEDULE_PASSWORD);
        }
        //댓글 삭제
        commentRepository.deleteAllByScheduleId(scheduleId);
        //존재하면 삭제
        schedulerepository.delete(schedule);
    }
}
