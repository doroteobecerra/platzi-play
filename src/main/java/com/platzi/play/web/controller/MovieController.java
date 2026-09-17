package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.services.MovieServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieServices movieServices;

    public MovieController(MovieServices movieServices) {
        this.movieServices = movieServices;
    }

    @GetMapping()
    public ResponseEntity<List<MovieDTO>> getAll(){
        return ResponseEntity.ok(this.movieServices.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getById(@PathVariable long id){
        MovieDTO movieDTO = this.movieServices.getById(id);
        if(movieDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movieDTO);
    }
}
