package com.campaigns.task.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CampaignNotFoundException.class)
    public ResponseEntity<?> handleNoSuchElementException(CampaignNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(InsufficientAccountBalance.class)
    public ResponseEntity<?> handleInsufficientAccountBalance(InsufficientAccountBalance e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
