package com.example.challengeschedule.controller;

import com.example.challengeschedule.dto.CommentRequest;
import com.example.challengeschedule.dto.CommentResponse;
import com.example.challengeschedule.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController//Spring에서 Controller를 지정
@RequiredArgsConstructor//final 필드에 대한 생성자를 자동 생성
public class CommentController {
    private final CommentService commentService;

    //댓글 생성
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentResponse> createComment(@PathVariable Long scheduleId, @Valid @RequestBody CommentRequest commentRequest) {
        CommentResponse commentResult = commentService.commentSave(scheduleId, commentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResult);
    }
}
