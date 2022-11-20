package com.ssafy.buyhome.user.model.service;

import com.ssafy.buyhome.user.model.dao.UserDao;
import com.ssafy.buyhome.user.model.dto.Token;
import com.ssafy.buyhome.user.model.dto.User;
import com.ssafy.buyhome.user.model.exception.LoginFailedException;
import com.ssafy.buyhome.user.model.exception.UserNotFoundException;
import com.ssafy.buyhome.util.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GeneralAuthService implements AuthService{

    private final UserDao userDao;
    private final TokenProvider tokenProvider;

    @Override
    public Token login(String username, String password) {
        User user = userDao.selectByUsername(username);
        if (user == null) throw new UserNotFoundException();
        if (!user.getPassword().equals(password)) throw new LoginFailedException();
        return tokenProvider.createToken(user.getUsername(), user.getRole());
    }

    @Override
    public Token login(String code) {
        throw new RuntimeException();
    }

    @Override
    public void register(User user) {
        userDao.insert(user);
    }
}
