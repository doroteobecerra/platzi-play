package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.services.MovieServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieServices movieServices;

    public MovieController(MovieServices movieServices) {
        this.movieServices = movieServices;
    }

    @GetMapping("/movies")
    public List<MovieDTO> getAll(){
        return this.movieServices.getAll();
    }
}
