package com.ssafy.buyhome.qna.model.dao;

import com.ssafy.buyhome.qna.model.dto.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionDao {

    Question select(@Param("id") Integer questionId);

    void insert(Question question);

    void update(@Param("id") Integer questionId, @Param("data") Question data);

    void delete(@Param("id") Integer questionId);

    List<Question> selectAll();

}
