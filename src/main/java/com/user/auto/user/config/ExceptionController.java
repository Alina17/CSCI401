package com.user.auto.user.config;

import com.user.auto.user.model.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

//    @ExceptionHandler
//    public ResponseEntity<Object> CustomErrorHandler(Exception exception, WebRequest request) {
//
//        CustomErrorResponse errors = new CustomErrorResponse();
//        errors.setTimestamp(LocalDateTime.now());
//        errors.setError(exception.getMessage());
//        errors.setStatus(HttpStatus.UNAUTHORIZED.value());
//
//
//        return new ResponseEntity<>(errors,HttpStatus.UNAUTHORIZED);
//
//    }
}
