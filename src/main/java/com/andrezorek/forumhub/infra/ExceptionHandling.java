package com.andrezorek.forumhub.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleElementNotFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(){
        return ResponseEntity.notFound().build();
    }
}
