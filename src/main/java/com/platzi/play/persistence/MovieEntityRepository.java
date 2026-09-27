package com.platzi.play.persistence;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.domain.dto.UpdateMovieDTO;
import com.platzi.play.domain.exception.MovieAlredyExistsException;
import com.platzi.play.domain.repository.MovieRepository;
import com.platzi.play.persistence.crud.CrudMovieEntity;
import com.platzi.play.persistence.entity.MovieEntity;
import com.platzi.play.persistence.mapper.MovieMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MovieEntityRepository implements MovieRepository {
    private final CrudMovieEntity crudMovieEntity;
    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity, MovieMapper movieMapper) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDTO> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDTO getById(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);
        return this.movieMapper.toDto(movieEntity);
    }

    @Override
    public MovieDTO save(MovieDTO movieDTO) {
        if(this.crudMovieEntity.findFirstByTitulo(movieDTO.title()) != null){
            throw new MovieAlredyExistsException(movieDTO.title());
        }
        MovieEntity movieEntity = this.movieMapper.toEntity(movieDTO);
        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDTO update(long id, UpdateMovieDTO updateMovieDTO) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if(movieEntity == null){
            return null;
        }
        if(this.crudMovieEntity.findFirstByTitulo(updateMovieDTO.title()) != null){
            throw new MovieAlredyExistsException(updateMovieDTO.title());
        }


        movieEntity.setTitulo(updateMovieDTO.title());
        movieEntity.setFechaEstreno(updateMovieDTO.releaseData());
        movieEntity.setClasificacion(BigDecimal.valueOf(updateMovieDTO.rating()));

        this.movieMapper.updateEntityFromDto(updateMovieDTO, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public void delete(long id) {
        if (!this.crudMovieEntity.existsById(id)) {
            throw new RuntimeException("La película no existe");
        }
        this.crudMovieEntity.deleteById(id);
    }
}
