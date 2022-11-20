package com.ssafy.buyhome.exception;

public class BusinessUnauthorizedException extends RuntimeException{
    public BusinessUnauthorizedException(String message) {
        super(message);
    }
}
