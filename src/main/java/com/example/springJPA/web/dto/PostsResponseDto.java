package com.example.springJPA.web.dto;

import com.example.springJPA.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;//pk
    private String title;//제목
    private String content;//본문
    private String author;//작성자

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
