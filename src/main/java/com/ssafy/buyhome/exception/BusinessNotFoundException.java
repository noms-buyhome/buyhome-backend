package com.ssafy.buyhome.exception;

public abstract class BusinessNotFoundException extends RuntimeException {
    public BusinessNotFoundException(String message) {
        super(message);
    }
}
