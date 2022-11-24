package com.ssafy.buyhome.qna.model.service;

import com.ssafy.buyhome.qna.model.dao.QuestionDao;
import com.ssafy.buyhome.qna.model.dto.Answer;
import com.ssafy.buyhome.qna.model.dto.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void create(Question question) {
        questionDao.insert(question);
    }

    public void update(Integer questionId, Question question) {
        question.setId(questionId);
        questionDao.update(question);
    }

    public void createAnswerToQuestion(Answer answer, Integer qnaId) {
        questionDao.createAnswerToQuestion(answer, qnaId);
    }

    public void updateAnswer(Integer answerId, Answer answer) {
        answer.setId(answerId);
        questionDao.updateAnswer(answer);
    }

    @Transactional
    public void deleteAnswer(Integer answerId) {
        questionDao.deleteAnswerById(answerId);
    }
}
