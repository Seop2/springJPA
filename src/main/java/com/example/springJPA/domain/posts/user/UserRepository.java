package com.example.springJPA.domain.posts.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User>findByEmail(String email);//email을 통해 가입된 사용자 확인
}
