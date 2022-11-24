package com.ssafy.buyhome.user.model.service;

import com.ssafy.buyhome.qna.model.dao.QuestionDao;
import com.ssafy.buyhome.qna.model.dto.Question;
import com.ssafy.buyhome.user.model.dao.UserDao;
import com.ssafy.buyhome.user.model.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;
    private final QuestionDao questionDao;

    @Transactional
    public User findById(int userId) {
        return userDao.select(userId);
    }

    @Transactional
    public User findByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Transactional
    public void update(Integer userId, User incomingData) {
        userDao.update(userId, incomingData);
    }

    @Transactional
    public void delete(Integer userId) {
        for (Question question : questionDao.selectAllByUserID(userId)) {
            questionDao.deleteAnswerByQuestionId(question.getId());
        }
        questionDao.deleteQuestionByUserId(userId);
        userDao.delete(userId);
    }
}
