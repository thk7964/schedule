package com.example.schedule.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(length = 200, nullable = false)
    private String content;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String password;

    public Schedule(String title, String content,String name, String password){
        this.title=title;
        this.content=content;
        this.name=name;
        this.password=password;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
