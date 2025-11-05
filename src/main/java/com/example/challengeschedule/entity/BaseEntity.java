package com.example.challengeschedule.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter//클래스 모든 필드에 대해 자동으로 게터 메서드를 생성
@MappedSuperclass//객체의 입장에서 공통 매핑 정보가 필요할 때 사용
@EntityListeners(AuditingEntityListener.class)//JPA 엔티티의 특정 이벤트(저장, 수정 등)가 발생했을 때, 이를 감지하여 자동으로 특정 작업을 수행할 수 있도록 도와주는 기능
public abstract class BaseEntity {

    @CreatedDate//Entity가 생성되어 저장될 때 시간이 자동으로 저장
    @Column(updatable = false)//더 이상 수정되지 않게한다.
    private LocalDateTime createdAt;// 저장된 시간

    @LastModifiedDate//조회한 Entity의 값을 변경할 때 시간이 자동으로 저장
    private LocalDateTime modifiedAt;// 수정된 시간
}