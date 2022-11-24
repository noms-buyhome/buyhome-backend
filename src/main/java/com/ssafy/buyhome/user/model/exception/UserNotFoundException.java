package com.ssafy.buyhome.user.model.exception;

import com.ssafy.buyhome.exception.BusinessNotFoundException;

public class UserNotFoundException extends BusinessNotFoundException {
    public UserNotFoundException() {
        super("가입되지 않은 회원입니다.");
    }
}
