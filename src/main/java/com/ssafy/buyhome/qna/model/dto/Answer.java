package com.ssafy.buyhome.qna.model.dto;

import com.ssafy.buyhome.user.model.dto.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Answer {

    private Integer id;
    private User author;
    private String title;
    private String content;
    private LocalDateTime createdTime;
}
