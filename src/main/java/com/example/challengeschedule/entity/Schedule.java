package com.example.challengeschedule.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// 기본키
    @Column(length = 30, nullable = false)// 최대길이 30, null 불가
    private String title;//일정 제목
    @Column(length = 200, nullable = false)// 최대길이 200, null 불가
    private String content;//일정 내용
    @Column(length = 50, nullable = false)// 최대길이 50, null 불가
    private String name;//작성자명
    @Column(length = 30, nullable = false)// 최대길이 30, null 불가
    private String password;//비밀번호

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schedule", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Comment> comments=new ArrayList<>();

    //생성자
    public Schedule(String title, String content,String name, String password){
        this.title=title;
        this.content=content;
        this.name=name;
        this.password=password;
    }

    //일정 수정(제목과 작성자명 변경)
    public void update(String title, String name){
        this.title=title;
        this.name=name;
    }
}

