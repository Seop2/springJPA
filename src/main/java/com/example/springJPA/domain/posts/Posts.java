package com.example.springJPA.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity//jpa -> 테이블하고 링크할거임!
//Entity 클래스에서는 절대 setter메소드를 만들지 않는다
//차후 기능 변경시 복잡해짐
@NoArgsConstructor//기본 생성자 자동추가
public class Posts extends BaseTimeEntity{
    @Id//pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment 설정
    private Long id;//왠만하면 Long타입
    @Column(length = 500, nullable = false)//테이블 칼럼을 나타냄 값을 수정하거나 타임을 변경시 사용
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder//빌더가 기본적으로 setter의 역할을 한다
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
