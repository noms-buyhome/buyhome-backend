package com.ssafy.buyhome.qna.model.dto;

import com.ssafy.buyhome.user.model.dto.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    private long id;
    private User author;
    private String title;
    private String content;
    private LocalDateTime createdTime;
}
