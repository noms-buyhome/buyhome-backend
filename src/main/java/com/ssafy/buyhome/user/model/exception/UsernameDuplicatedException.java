package com.ssafy.buyhome.user.model.exception;

import com.ssafy.buyhome.exception.BusinessDuplicatedException;

public class UsernameDuplicatedException extends BusinessDuplicatedException {
    public UsernameDuplicatedException() {
        super("이미 존재하는 회원입니다.");
    }
}
