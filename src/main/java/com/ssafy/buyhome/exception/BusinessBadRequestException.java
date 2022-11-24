package com.ssafy.buyhome.exception;

public abstract class BusinessBadRequestException extends RuntimeException {
    public BusinessBadRequestException(String message) {
        super(message);
    }
}
