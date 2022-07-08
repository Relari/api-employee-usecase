//package com.example.demoapi.exception.exclude;
//
//import com.example.demoapi.exception.ErrorModel;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.util.Objects;
//
//@ControllerAdvice
//public class ExceptionHandlerFactory {
//
//    private static final String ERROR_CODE = "R0001";
//
//    @Value("${spring.application.name}")
//    private String applicationName;
//
//    @ExceptionHandler({DemoNotFoundException.class})
//    public HttpEntity<ErrorModel> demoNotFoundException(DemoNotFoundException e){
//
//        var errorModelBuilder = ErrorModel.builder();
//
//        if (Objects.isNull(e.getCode())) {
//            errorModelBuilder.code(e.getErrorCategory().getCode());
//        } else {
//            errorModelBuilder.code(e.getCode());
//        }
//
//        if (Objects.isNull(e.getMessage())) {
//            errorModelBuilder.message(e.getErrorCategory().getMessage());
//        } else {
//            errorModelBuilder.message(e.getMessage());
//        }
//
//        if (Objects.nonNull(e.getCause())) {
//            errorModelBuilder.cause(e.getCause());
//        }
//
//        errorModelBuilder.applicationName(applicationName);
//
//        return ResponseEntity
//                .status(e.getErrorCategory().getHttpStatus())
//                .body(errorModelBuilder.build());
//    }
//
//}
