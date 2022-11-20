package com.ssafy.buyhome.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private String username; // 로그인 시 입력하는 이름
    private String nickname; // 서비스 내 표시되는 이름
    private String password;
    private String email;
    private LocalDateTime createdTime;

    private String role;

    public User(String username, String nickname, String role) {
        this.username = username;
        this.nickname = nickname;
        this.role = role;
        this.password = "cannot empty";
    }
}
