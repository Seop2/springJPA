package com.example.springJPA.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//맵핑할 클래스(엔티티)와 타입 상속
//엔티티와 리포지토리는 함께 있어야 한다!
public interface PostsRepository extends JpaRepository<Posts,Long> {//기본적인 crud자동생성

}
