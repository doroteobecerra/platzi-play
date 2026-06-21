package com.platzi.play;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiServices {

    @UserMessage("""
           Genera un saludo de bienvenida a la plataforma de gestión de películas PlatziPlay. Usa menos de 120 caracteres y hazlo con un estilo amigable.
            """)
    String genereteGreeting();
}
