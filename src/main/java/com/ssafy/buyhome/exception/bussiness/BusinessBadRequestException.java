package com.ssafy.buyhome.exception.bussiness;

public abstract class BusinessBadRequestException extends RuntimeException {
    public BusinessBadRequestException(String message) {
        super(message);
    }
}
