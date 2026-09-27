package com.platzi.play.domain.services;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiServices {

    @UserMessage("""
           Genera un saludo de bienvenida a la plataforma de gestión de películas {{plataform}}. Usa menos de 120 caracteres y hazlo con un estilo amigable.
            """)
    String genereteGreeting(@V("plataform") String plataform);

    @SystemMessage("""
            Eres un experto en cine que recomienda películas personalizadas según los gustos del ususario.
            Debes recomendar máximo 3 películas.
            No incluyas películas que estén por fuera de la plataforma PlatziPlay
            """)
    String generateMoviesSuggestion(@UserMessage String userMessage);


}
