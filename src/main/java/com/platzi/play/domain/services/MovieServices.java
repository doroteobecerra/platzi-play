package com.platzi.play.domain.services;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServices {
    private final MovieRepository movieRepository;

    public MovieServices(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getAll(){
        return this.movieRepository.getAll();
    }
}
