package com.example.challengeschedule.repository;

import com.example.challengeschedule.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    int countByScheduleId(Long scheduleId);// 댓글 개수 조회

    List<Comment> findAllByScheduleId(Long scheduleId);//일정에 달린 모든 댓글 조회
}
