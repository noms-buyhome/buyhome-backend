package com.ssafy.buyhome.qna.model.dao;

import com.ssafy.buyhome.qna.model.dto.Answer;
import com.ssafy.buyhome.qna.model.dto.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionDao {

    Question select(@Param("id") Integer questionId);

    List<Question> selectAllByUserID(@Param("userId") Integer userId);

    void insert(Question question);

    void update(Question question);
    void deleteQuestionById(@Param("id") Integer questionId);
    void deleteQuestionByUserId(@Param("userId") Integer userId);
    void deleteAnswerByQuestionId(@Param("questionId") Integer questionId);
    List<Question> selectAll();

    void createAnswerToQuestion(@Param("answer") Answer answer, @Param("questionId") Integer questionId);

    void updateAnswer(Answer answer);

    void deleteAnswerById(@Param("id") Integer answerId);

    Answer selectAnswerById(Integer answerId);
}
