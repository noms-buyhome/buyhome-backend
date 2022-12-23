package com.ssafy.buyhome.qna.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface QuestionVoteDao {

    boolean isExist(@Param("questionId")Integer qnaId, @Param("userId") Integer userId);

    void vote(@Param("questionId")Integer qnaId, @Param("userId") Integer userId);

    void unvote(@Param("questionId")Integer qnaId, @Param("userId") Integer userId);

}
