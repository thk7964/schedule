package com.example.challengeschedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
@Entity//DB의 테이블과 매칭
@Table(name = "comments")//댓글 테이블 매핑
@NoArgsConstructor(access = AccessLevel.PROTECTED)//기본 생성자(JPA 내부용)
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 기본키를 DB의 AUTO_INCREMENT 방식으로 자동 생성
    private Long commentId;// 기본키
    @Column(length = 100, nullable = false)// 최대길이 100, null 불가
    private String commentContent;//댓글 내용
    @Column(length = 50, nullable = false)// 최대길이 50, null 불가
    private String commentName;//댓글 작성자명
    @Column(length = 30, nullable = false)// 최대길이 30, null 불가
    private String commentPassword;//댓글 비밀번호
    //댓글과 일정의 연관관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)//댓글과 일정의 schedule_id로 연결한다.(nullable = false: 반드시 하나의 일정에 속해야된다.)
    private Schedule schedule;

    //생성자
    public Comment(Schedule schedule, String commentContent, String commentName, String commentPassword) {
        this.commentContent = commentContent;
        this.commentName = commentName;
        this.commentPassword = commentPassword;
        this.schedule = schedule;
    }
}

