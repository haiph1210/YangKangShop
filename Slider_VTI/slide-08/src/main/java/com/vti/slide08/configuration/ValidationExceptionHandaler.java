//package com.vti.slide08.configuration;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class ValidationExceptionHandaler extends ResponseEntityExceptionHandler {
//
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        Map<String, String> errors = new HashMap<>();
//        for (FieldError error : exception.getFieldErrors()) {
//            String field = error.getField();
//            String message = error.getDefaultMessage();
//            errors.put(field, message);
//        }
//        return new ResponseEntity<>(errors, status);
//    }
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
//        Map<String, String> errors = new HashMap<>();
//
//        for (ConstraintViolation violation : exception.getConstraintViolations()) {
//            String field = violation.getPropertyPath().toString();
//            String message = violation.getMessage();
//            errors.put(field, message);
//        }
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
//}
//
