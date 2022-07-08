//package com.example.demoapi.exception.exclude;
//
//import lombok.Getter;
//import org.springframework.http.HttpStatus;
//
//public enum ErrorCategory {
//
//    ERROR_NOT_FOUND("R0001", "No se encontro el recurso solicitado", HttpStatus.NOT_FOUND);
//
//    @Getter
//    private final String code;
//
//    @Getter
//    private final String message;
//
//    @Getter
//    private final HttpStatus httpStatus;
//    ErrorCategory(String code, String message, HttpStatus httpStatus) {
//        this.code = code;
//        this.message = message;
//        this.httpStatus = httpStatus;
//    }
//
//}
