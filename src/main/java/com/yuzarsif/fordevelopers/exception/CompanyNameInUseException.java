package com.yuzarsif.fordevelopers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CompanyNameInUseException extends RuntimeException {

    public CompanyNameInUseException(String message) {
        super(message);
    }
}
