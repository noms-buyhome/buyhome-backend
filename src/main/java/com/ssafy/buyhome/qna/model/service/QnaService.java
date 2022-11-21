package com.ssafy.buyhome.qna.model.service;

import com.ssafy.buyhome.qna.model.dao.QuestionDao;
import com.ssafy.buyhome.qna.model.dto.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QnaService {

    private final QuestionDao questionDao;

    public List<Question> searchAll() {
        List<Question> questions = questionDao.selectAll();
        System.out.println(questions);
        return questions;
    }

    public Question findById(int id) {
        return questionDao.select(id);
    }
}
