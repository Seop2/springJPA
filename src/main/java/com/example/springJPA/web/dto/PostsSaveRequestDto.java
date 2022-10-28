package com.example.springJPA.web.dto;


import com.example.springJPA.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor//파라미터 없는 기본 생성자 자동생성
@Getter
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Posts toEntity(){//posts으로 데이터를 보냄(DB등록)
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
