package com.example.springJPA.config.auth.dto;

import com.example.springJPA.domain.posts.user.User;
import lombok.Getter;
//인증된 사용자
import java.io.Serializable;
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
