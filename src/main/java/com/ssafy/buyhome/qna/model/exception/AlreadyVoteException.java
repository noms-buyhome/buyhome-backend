package com.ssafy.buyhome.qna.model.exception;

import com.ssafy.buyhome.exception.bussiness.BusinessDuplicatedException;

public class AlreadyVoteException extends BusinessDuplicatedException {
    public AlreadyVoteException() {
        super("이미 \"좋아요\" 한 게시물 입니다.");
    }
}
