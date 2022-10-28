package com.example.springJPA.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor//모든 final필드 생성자 생
@Getter//get메소드 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;//lombok쓰니까 getSet안쓰네? 개꿀!
}
