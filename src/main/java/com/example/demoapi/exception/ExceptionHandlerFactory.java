package com.example.demoapi.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerFactory {

    @Value("${spring.application.name}")
    private String applicationName;

    @ExceptionHandler({DemoNotFoundException.class})
    public HttpEntity<ErrorModel> demoNotFoundException(DemoNotFoundException e){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorModel(applicationName, e.getMessage()));
    }

}
