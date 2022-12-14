package com.ssafy.buyhome.user.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private int id;
    private String username; // 로그인 시 입력하는 이름
    private String nickname; // 서비스 내 표시되는 이름
    private String password;
    private String email;
    private LocalDateTime createdTime;

    private String authority;

    public User(String username, String nickname, String authority) {
        this.username = username;
        this.nickname = nickname;
        this.authority = authority;
        this.password = "cannot empty";
    }
}
