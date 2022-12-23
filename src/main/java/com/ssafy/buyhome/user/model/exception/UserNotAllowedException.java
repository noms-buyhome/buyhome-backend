package com.ssafy.buyhome.user.model.exception;

import com.ssafy.buyhome.exception.bussiness.BusinessForbiddenException;

public class UserNotAllowedException extends BusinessForbiddenException {
    public UserNotAllowedException() {
        super("권한이 없습니다.");
    }
}
