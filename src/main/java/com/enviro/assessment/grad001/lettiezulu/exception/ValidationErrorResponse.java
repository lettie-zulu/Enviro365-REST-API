package com.enviro.assessment.grad001.lettiezulu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ValidationErrorResponse extends RuntimeException {
    public ValidationErrorResponse(String message) {
        super(message);
    }
}
