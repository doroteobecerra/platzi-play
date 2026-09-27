package com.platzi.play.domain.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdateMovieDTO(
        @NotBlank(message = "El titulo es obligatorio")
        String title,

        @PastOrPresent(message = "La fecha de lanzamiento debe ser menor a la fecha actual")
        LocalDate releaseData,

        @Min(value = 0, message = "El rating no puede ser menor a 0")
        @Max(value = 5, message = "El rating no puede ser mayor a 5")
        Double rating
) {
}
