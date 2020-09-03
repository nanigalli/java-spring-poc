package com.galli.poc.controller;

import com.galli.poc.exception.NotFoundException;
import com.galli.poc.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    public static final String FATAL_ERROR_MESSAGE = "Please, contact support for further information";

    @ExceptionHandler(value = { NotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(ErrorResponse.ErrorCode.NOT_FOUND, ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { Exception.class})
    protected ResponseEntity<ErrorResponse> handleFatalError(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(ErrorResponse.ErrorCode.FATAL_ERROR, FATAL_ERROR_MESSAGE), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
