package com.ssafy.buyhome.user.model.service;

import com.ssafy.buyhome.user.model.dao.UserDao;
import com.ssafy.buyhome.user.model.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User findById(int userId) {
        return userDao.select(userId);
    }

    public void create(User user) {
        userDao.insert(user);
    }

    public void update(Integer userId, User incomingData) {
        userDao.update(userId, incomingData);
    }

    public void delete(Integer userId) {
        userDao.delete(userId);
    }
}
