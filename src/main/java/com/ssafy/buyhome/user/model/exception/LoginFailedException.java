package com.ssafy.buyhome.user.model.exception;

import com.ssafy.buyhome.exception.bussiness.BusinessBadRequestException;

public class LoginFailedException extends BusinessBadRequestException {

    public LoginFailedException() {
        super("로그인에 실패했습니다.");
    }

}
