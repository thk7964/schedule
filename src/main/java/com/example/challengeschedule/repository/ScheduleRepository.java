package com.example.challengeschedule.repository;


import com.example.challengeschedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //작성자명으로 조회(수정일 기준 내림차순)
    List<Schedule> findAllByNameOrderByModifiedAtDesc(String name);
    //전체 조회 (수정일 기준 내림차순)
    List<Schedule> findAllByOrderByModifiedAtDesc();
}
