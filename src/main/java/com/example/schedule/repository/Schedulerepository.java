package com.example.schedule.repository;


import com.example.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Schedulerepository extends JpaRepository<Schedule, Long> {


}
