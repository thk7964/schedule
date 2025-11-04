package com.example.challengeschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication// 스프링 부트 애플리케이션 진입점 지정
@EnableJpaAuditing //엔티티의 생성/수정 시간 자동 관리 활성화
public class ChallengeScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeScheduleApplication.class, args);
    }

}
