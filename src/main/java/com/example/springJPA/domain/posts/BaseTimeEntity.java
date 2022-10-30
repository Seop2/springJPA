package com.example.springJPA.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@Getter
@MappedSuperclass//entity클래스들과 매핑
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {//entity들을 자동으로 관리
    @CreatedDate//entity가 생성되어 저장될때 시간이 자동으로 저장됨
    private LocalDateTime createDate;
    @LastModifiedDate//변경된 값 자동 저장
    private LocalDateTime modifiedDate;

}
