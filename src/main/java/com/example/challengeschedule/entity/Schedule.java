package com.example.challengeschedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
@Entity//DB의 테이블과 매칭
@Table(name = "schedules")//일정 테이블 매핑
@NoArgsConstructor(access = AccessLevel.PROTECTED)//기본 생성자(JPA 내부용)
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 기본키를 DB의 AUTO_INCREMENT 방식으로 자동 생성
    private Long id;// 기본키
    @Column(length = 30, nullable = false)// 최대길이 30, null 불가
    private String title;//일정 제목
    @Column(length = 200, nullable = false)// 최대길이 200, null 불가
    private String content;//일정 내용
    @Column(length = 50, nullable = false)// 최대길이 50, null 불가
    private String name;//작성자명
    @Column(length = 30, nullable = false)// 최대길이 30, null 불가
    private String password;//비밀번호
    //일정과 댓글의 연관관계 설정(cascade = CascadeType.ALL: 일정 삭제시 댓글도 함께 삭제, orphanRemoval = true : 댓글이 일정이 관계가 끊기면 자동으로 삭제됨)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Comment> comments = new ArrayList<>();//댓글 리스트

    //생성자
    public Schedule(String title, String content, String name, String password) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.password = password;
    }

    //일정 수정(제목과 작성자명 변경)
    public void update(String title, String name) {
        this.title = title;
        this.name = name;
    }
}

