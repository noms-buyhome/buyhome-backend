package com.ssafy.buyhome.exception;

public abstract class BusinessUnauthorizedException extends RuntimeException{
    public BusinessUnauthorizedException(String message) {
        super(message);
    }
}
