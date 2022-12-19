package com.ssafy.buyhome.exception.bussiness;

public abstract class BusinessNotFoundException extends RuntimeException {
    public BusinessNotFoundException(String message) {
        super(message);
    }
}
