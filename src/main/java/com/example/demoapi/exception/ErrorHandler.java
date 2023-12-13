package com.example.demoapi.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandler {

    @Value("${spring.application.name}")
    private String applicationName;

    @ExceptionHandler(DemoNotFoundException.class)
    public HttpEntity<ErrorModel> demoNotFoundException(
            DemoNotFoundException e) {
        return buildError(
                HttpStatus.NOT_FOUND, e.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    public HttpEntity<ErrorModel> exception(Exception e) {
        return buildError(
                HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()
        );
    }

    private ResponseEntity<ErrorModel> buildError(
            HttpStatus status, String message) {
        return ResponseEntity
                .status(status)
                .body(new ErrorModel(
                        applicationName, status.value(), message
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorModel> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> parameters= new ArrayList<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error ->
                        parameters.add("Field = " + error.getField() + ", Message = " + error.getDefaultMessage())
                );
        return buildError(
                HttpStatus.BAD_REQUEST, parameters.size() == 1 ? parameters.get(0) : "Texto Invalido"
        );
    }
}
