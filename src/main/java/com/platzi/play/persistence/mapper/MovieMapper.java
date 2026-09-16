package com.platzi.play.persistence.mapper;

import com.platzi.play.domain.dto.MovieDTO;
import com.platzi.play.persistence.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre")
    @Mapping(source = "fechaEstreno", target = "releaseData")
    @Mapping(source = "clasificacion", target = "rating")
    MovieDTO toDto(MovieEntity entity);
    List<MovieDTO> toDto(Iterable<MovieEntity> entities);


}
