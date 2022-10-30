package com.example.springJPA.web;

import com.example.springJPA.service.posts.PostsService;
import com.example.springJPA.web.dto.PostsResponseDto;
import com.example.springJPA.web.dto.PostsSaveRequestDto;
import com.example.springJPA.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")//insert api
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")//수정 api
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")//특정 게시물 조회 api
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
