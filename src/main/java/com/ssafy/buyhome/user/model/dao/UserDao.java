package com.ssafy.buyhome.user.model.dao;

import com.ssafy.buyhome.user.model.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User select(String userId);

    void insert(User user);
}
