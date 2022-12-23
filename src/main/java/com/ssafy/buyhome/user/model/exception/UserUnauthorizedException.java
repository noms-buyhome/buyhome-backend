package com.ssafy.buyhome.user.model.exception;

import com.ssafy.buyhome.exception.bussiness.BusinessUnauthorizedException;

public class UserUnauthorizedException extends BusinessUnauthorizedException {
    public UserUnauthorizedException() {
        super("로그인이 필요한 서비스입니다.");
    }
}
