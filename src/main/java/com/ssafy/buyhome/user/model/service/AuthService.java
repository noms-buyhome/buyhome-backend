package com.ssafy.buyhome.user.model.service;

import com.ssafy.buyhome.user.model.dto.Token;
import com.ssafy.buyhome.user.model.dto.User;

public interface AuthService {

    Token login(String username, String password);
    Token login(String code);
    void register(User user);
}
