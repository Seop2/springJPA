package com.example.springJPA.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;
    @After//단위 테스트가 끝날때마다 수행되는 메소드를 지정
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void board_import(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()//insert와 update둘다 가능 (id가 있다면 update, 없다면 insert)
                        .title(title)
                        .content(content)
                        .author("lk9050@naver.com")
                        .build());
        List<Posts>postsList = postsRepository.findAll();//post에 있는 모든 데이터 조회

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);//값을 비교
        assertThat(posts.getContent()).isEqualTo(content);
    }
    @Test
    public void BaseTimeEntity_regist(){
        LocalDateTime now = LocalDateTime.of(2022,10,29,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>>>>>> createDate = "+posts.getCreateDate()+", modifedDate = "+posts.getModifiedDate());
        //isAfter(): 인자보다 미래일때 true
        //isBefore(): 인자보다 과거일때  true
        //isEqual(): 인자와 같은 날짜일때 true
        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
