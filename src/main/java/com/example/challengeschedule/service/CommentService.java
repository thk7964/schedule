package com.example.challengeschedule.service;

import com.example.challengeschedule.dto.CommentRequest;
import com.example.challengeschedule.dto.CommentResponse;
import com.example.challengeschedule.entity.Comment;
import com.example.challengeschedule.entity.Schedule;
import com.example.challengeschedule.exception.CustomException;
import com.example.challengeschedule.exception.ErrorCode;
import com.example.challengeschedule.repository.CommentRepository;
import com.example.challengeschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor//final 필드에 대한 생성자를 자동 생성
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository schedulerepository;

    //댓글 생성
    @Transactional
    public CommentResponse commentSave(Long scheduleId, CommentRequest commentRequest) {
        //일정 존재여부 확인
        Schedule schedule = schedulerepository.findById(scheduleId).orElseThrow(
                () -> new CustomException(ErrorCode.SCHEDULE_NOT_FOUND)
        );
        //댓글이 10개 이하인지 확인
        int commentCount = commentRepository.countByScheduleId(scheduleId);
        if (commentCount >= 10) {
            throw new CustomException(ErrorCode.COMMENT_LIMIT_EXCEEDED);
        }
        //요청값을 기반으로 댓글 엔티티 생성
        Comment comment = new Comment(schedule, commentRequest.getCommentContent(), commentRequest.getCommentName(), commentRequest.getCommentPassword());
        Comment saveComment = commentRepository.save(comment);//DB에 저장

        return new CommentResponse(
                saveComment.getCommentId(),
                saveComment.getCommentContent(),
                saveComment.getCommentName(),
                saveComment.getCreatedAt(),
                saveComment.getModifiedAt()
        );
    }

}
