package com.ssafy.buyhome.exception.bussiness;

public abstract class BusinessUnauthorizedException extends RuntimeException{
    public BusinessUnauthorizedException(String message) {
        super(message);
    }
}
