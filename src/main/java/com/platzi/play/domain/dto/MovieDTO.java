package com.platzi.play.domain.dto;

import java.time.LocalDate;

public record MovieDTO(
        String title,
        Integer duration,
        String genre,
        LocalDate releaseData,
        Double rating
) {
}
