package com.example.springJPA.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)//스프링부트 테스트와 junit사이에 연결자 역할을 한다
@WebMvcTest(controllers = HelloController.class)//웹에 집중
public class HelloControllerTest {
    @Autowired//스프링이 관리하는 빈을 주입받음
    private MockMvc mvc;//웹 API를 테스트할때 사용

    @Test
    public void helloReturn()throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))//http get요청
                .andExpect(status().isOk())//200인지 아닌지 검증
                .andExpect(content().string(hello));//hello 리턴
    }
    public void helloDtoReturn()throws Exception{
        String name = "hello";
        int amount  = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)//api 테스트할때 사용될 요청 파라미터를 설정
                        .param("amount", String.valueOf(amount)))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))//200인지 아닌지 검증
                .andExpect(jsonPath("$.amount",is(amount)));//200인지 아닌지 검증
        }
    }
//    @GetMapping("/hello")
//    public String hello(){
//        return "hello";
//    }
