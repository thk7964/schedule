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

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentResponse> createComment(@Valid  @PathVariable Long scheduleId, @RequestBody CommentRequest commentRequest) {
        CommentResponse commentResult = commentService.commentSave(scheduleId, commentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentResult);
    }
}
