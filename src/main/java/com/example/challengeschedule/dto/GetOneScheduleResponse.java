package com.example.challengeschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
public class GetOneScheduleResponse extends ScheduleResponse {//일정 조회에 대한 응답 DTO
    private final List<CommentResponse> components;
    //일정에 댓글이 있는 경우
    public GetOneScheduleResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt, List<CommentResponse> components) {
        super(id, title, content, name, createdAt, modifiedAt);
        this.components=components;
    }
    //일정에 댓글잉 없는 경우
    public GetOneScheduleResponse(Long id, String title, String content, String name, LocalDateTime createdAt, LocalDateTime modifiedAt){
        super(id, title, content, name, createdAt, modifiedAt);
        this.components=null;
    }
}
