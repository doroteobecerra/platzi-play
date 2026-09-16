package com.platzi.play.domain.dto;

import com.platzi.play.domain.Genre;

import java.time.LocalDate;

public record MovieDTO(
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseData,
        Double rating
) {
}
