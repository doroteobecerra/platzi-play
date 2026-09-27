package com.platzi.play.web.exception;

import com.platzi.play.domain.exception.MovieAlredyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHadler {
    @ExceptionHandler(MovieAlredyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlredyExistsException ex){
        Error error = new Error("movie-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
