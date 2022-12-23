package com.ssafy.buyhome.qna.model.exception;

import com.ssafy.buyhome.exception.bussiness.BusinessNotFoundException;

public class VoteNotFoundException extends BusinessNotFoundException {
    public VoteNotFoundException() {
        super("\"좋아요\" 하지 않은 게시물입니다.");
    }
}
