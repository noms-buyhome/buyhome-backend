package com.ssafy.buyhome.qna.model.service;

import com.ssafy.buyhome.qna.model.dao.QuestionVoteDao;
import com.ssafy.buyhome.qna.model.exception.AlreadyVoteException;
import com.ssafy.buyhome.qna.model.exception.VoteNotFoundException;
import com.ssafy.buyhome.user.model.dao.UserDao;
import com.ssafy.buyhome.user.model.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionVoteService {

    private final QuestionVoteDao questionVoteDao;
    private final UserDao userDao;

    public void vote(Integer qnaId, String username) {
        User user = userDao.selectByUsername(username);
        if (questionVoteDao.isExist(qnaId,user.getId())) throw new AlreadyVoteException();
        questionVoteDao.vote(qnaId, user.getId());
    }

    public void unvote(Integer qnaId, String username) {
        User user = userDao.selectByUsername(username);
        if (!questionVoteDao.isExist(qnaId,user.getId())) throw new VoteNotFoundException();
        questionVoteDao.unvote(qnaId, user.getId());
    }
}
