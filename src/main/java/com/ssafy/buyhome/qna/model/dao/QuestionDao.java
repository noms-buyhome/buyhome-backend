package com.ssafy.buyhome.qna.model.dao;

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
    void delete(@Param("id") Integer questionId);
    void deleteQuestionByUserId(@Param("userId") Integer userId);
    void deleteAnswerByQuestionId(@Param("questionId") Integer questionId);
    List<Question> selectAll();

}
