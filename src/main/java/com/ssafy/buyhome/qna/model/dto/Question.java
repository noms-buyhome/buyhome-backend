package com.ssafy.buyhome.qna.model.dto;

import com.ssafy.buyhome.user.model.dto.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {

    private Integer id;
    private User author;
    private String title;
    private String content;
    private List<Answer> answers;
    private LocalDateTime createdTime;
}
