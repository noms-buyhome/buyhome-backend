package com.ssafy.buyhome.user.model.dao;

import com.ssafy.buyhome.user.model.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User select(@Param("id") int userId);

    void insert(User user);

    void update(@Param("id") Integer userId, @Param("data") User data);
}
