package com.example.challengeschedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse  {
    private final Long commentId;
    private final String commentContent;
    private final String commentName;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentResponse(Long commentId, String commentContent, String commentName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentName = commentName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;

    }
}
