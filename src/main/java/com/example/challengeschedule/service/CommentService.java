package com.example.challengeschedule.service;

import com.example.challengeschedule.dto.CommentRequest;
import com.example.challengeschedule.dto.CommentResponse;
import com.example.challengeschedule.entity.Comment;
import com.example.challengeschedule.entity.Schedule;
import com.example.challengeschedule.repository.CommentRepository;
import com.example.challengeschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository schedulerepository;
    //댓글 생성
    @Transactional
    public CommentResponse commentSave(Long scheduleId, CommentRequest commentRequest){
        //일정 존재여부 확인
        Schedule schedule = schedulerepository.findById(scheduleId).orElseThrow(
                ()-> new IllegalStateException("존재하지 않는 일정입니다.")
        );
        //댓글이 10개 이하인지 확인
        if (schedule.getComments().size() >= 10) {
            throw new IllegalStateException("댓글은 최대 10개까지만 작성할 수 있습니다.");
        }
        //요청값을 기반으로 댓글 엔티티 생성
        Comment comment= new Comment(schedule,commentRequest.getCommentContent(), commentRequest.getCommentName(),commentRequest.getCommentPassword());
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
