package com.ssafy.buyhome.exception.bussiness;

public abstract class BusinessDuplicatedException extends RuntimeException{
    public BusinessDuplicatedException(String message) {
        super(message);
    }
}
