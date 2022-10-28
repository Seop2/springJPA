package com.example.springJPA.service.posts;

import com.example.springJPA.domain.posts.Posts;
import com.example.springJPA.domain.posts.PostsRepository;
import com.example.springJPA.web.dto.PostsResponseDto;
import com.example.springJPA.web.dto.PostsSaveRequestDto;
import com.example.springJPA.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//트랜잭션, 도메인간 순서 보장
@RequiredArgsConstructor//final 생성자 자동생성
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
