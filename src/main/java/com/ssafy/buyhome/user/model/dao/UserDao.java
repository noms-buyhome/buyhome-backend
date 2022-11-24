package com.ssafy.buyhome.user.model.dao;

import com.ssafy.buyhome.user.model.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    User select(@Param("id") int userId);
    User selectByUsername(@Param("username") String username);
    void insert(User user);

    void update(@Param("id") Integer userId, @Param("data") User data);

    void delete(@Param("id") Integer userId);
}
