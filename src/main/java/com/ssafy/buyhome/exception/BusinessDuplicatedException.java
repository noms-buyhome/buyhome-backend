package com.ssafy.buyhome.exception;

public abstract class BusinessDuplicatedException extends RuntimeException{
    public BusinessDuplicatedException(String message) {
        super(message);
    }
}
