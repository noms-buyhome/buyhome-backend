package com.ssafy.buyhome.exception.handler;

import com.ssafy.buyhome.exception.bussiness.BusinessBadRequestException;
import com.ssafy.buyhome.exception.bussiness.BusinessDuplicatedException;
import com.ssafy.buyhome.exception.bussiness.BusinessNotFoundException;
import com.ssafy.buyhome.exception.bussiness.BusinessUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(BusinessBadRequestException.class)
    public ResponseEntity<?> handleBadRequest(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessNotFoundException.class)
    public ResponseEntity<?> handleNotFound(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessUnauthorizedException.class)
    public ResponseEntity<?> handleUnauthorized(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BusinessDuplicatedException.class)
    public ResponseEntity<?> handleDuplicated(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
