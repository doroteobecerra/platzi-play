package com.platzi.play.web.controller;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.dto.UpdateMovieDTO;
import com.platzi.play.domain.services.MovieServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<MovieDTO> add(@RequestBody MovieDTO movieDTO){
        MovieDTO movieResponse = this.movieServices.add(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable long id,@RequestBody UpdateMovieDTO updateMovieDTO){
        return ResponseEntity.ok(this.movieServices.update(id, updateMovieDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        this.movieServices.delete(id);
    }
}
