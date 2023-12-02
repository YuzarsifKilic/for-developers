package com.yuzarsif.fordevelopers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotExistsException extends RuntimeException {

    public ProjectNotExistsException(String message) {
        super(message);
    }
}
