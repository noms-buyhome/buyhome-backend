package com.ssafy.buyhome.exception;

public abstract class BusinessForbiddenException extends RuntimeException{
    public BusinessForbiddenException(String message) {
        super(message);
    }
}
