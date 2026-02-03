package com.pm.patientservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.awt.image.RescaleOp;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailALreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailALreadyExistsException(EmailALreadyExistsException ex) {

        log.warn("Dear User:" + " Email address already exist {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Email Already Exists");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePatientNotFoundException(PatientNotFoundException ex){

        log.warn("Dear user: " + "Patient you are looking for doesn't exists : {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Patient Not Found");
        return ResponseEntity.badRequest().body(errors);
    }
}
