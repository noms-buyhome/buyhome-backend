package com.ssafy.buyhome.user.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Token {

    private String access;
    private String refresh;

}
