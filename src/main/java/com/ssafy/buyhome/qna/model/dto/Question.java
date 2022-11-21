package com.ssafy.buyhome.qna.model.dto;

import com.ssafy.buyhome.user.model.dto.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private long id;
    private User author;
    private String title;
    private String content;
    private List<Answer> answers;
    private LocalDateTime createdTime;
}
