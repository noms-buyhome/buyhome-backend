package com.ssafy.buyhome.user.model.service;

import com.ssafy.buyhome.user.model.dao.UserDao;
import com.ssafy.buyhome.user.model.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User findById(String userId) {
        return userDao.select(userId);
    }

    public void create(User user) {
        userDao.insert(user);
    }
}
