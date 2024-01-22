package com.yuzarsif.fordevelopers.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GithubValidateException.class)
    public ResponseEntity<ErrorResponse> handleGithubValidateException(GithubValidateException e, HttpServletResponse response) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AdvertisementNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAdvertisementNotFoundException(AdvertisementNotFoundException e, HttpServletResponse response) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCompanyNotFoundException(CompanyNotFoundException e, HttpServletResponse response) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCourseNotFoundException(CourseNotFoundException e, HttpServletResponse response) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DateConvertException.class)
    public ResponseEntity<ErrorResponse> handleDateConvertException(DateConvertException e, HttpServletResponse response) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException e, HttpServletResponse response) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UniversityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUniversityNotFoundException(UniversityNotFoundException e, HttpServletResponse response) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProjectNotExistsException.class)
    public ResponseEntity<ErrorResponse> handleProjectNotExistsException(ProjectNotExistsException e, HttpServletResponse response) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpClientErrorException(HttpClientErrorException e, HttpServletResponse response) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
