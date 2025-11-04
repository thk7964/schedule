package com.example.challengeschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChallengeScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeScheduleApplication.class, args);
    }

}
