package com.platzi.play.domain.exception;

public class MovieAlredyExistsException extends RuntimeException {
    public MovieAlredyExistsException(String movieTitle){
        super("La película " + movieTitle + " ya existe");
    }

}
