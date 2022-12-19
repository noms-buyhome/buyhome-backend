package com.ssafy.buyhome.exception.bussiness;

public abstract class BusinessForbiddenException extends RuntimeException{
    public BusinessForbiddenException(String message) {
        super(message);
    }
}
