package com.example.challengeschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
public class CommentResponse {
    private final Long commentId;//댓글의 id(기본키)
    private final String commentContent;//댓글 내용
    private final String commentName;//댓글 작성자명
    private final LocalDateTime createdAt;//댓글 작성일
    private final LocalDateTime modifiedAt;//댓글 수정일

    //생성자
    public CommentResponse(Long commentId, String commentContent, String commentName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentName = commentName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }
}
