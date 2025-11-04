package com.example.challengeschedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;// 기본키
    @Column(length = 100, nullable = false)// 최대길이 100, null 불가
    private String commentContent;//댓글 내용
    @Column(length = 50, nullable = false)// 최대길이 50, null 불가
    private String commentName;//댓글 작성자명
    @Column(length = 30, nullable = false)// 최대길이 30, null 불가
    private String commentPassword;//댓글 비밀번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    //생성자
    public Comment(Schedule schedule, String commentContent, String commentName, String commentPassword) {
        this.commentContent = commentContent;
        this.commentName = commentName;
        this.commentPassword = commentPassword;
        this.schedule=schedule;
    }
}

