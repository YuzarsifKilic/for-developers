package com.yuzarsif.fordevelopers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GithubUsernameInUseException extends RuntimeException {

    public GithubUsernameInUseException(String message) {
        super(message);
    }
}
