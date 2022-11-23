package com.ssafy.buyhome.qna.model.dao;

import com.ssafy.buyhome.qna.model.dto.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionDao {

    Question select(@Param("id") Integer questionId);

    void insert(Question question);

    void update(Question question);

    void delete(@Param("id") Integer questionId);

    List<Question> selectAll();

}
