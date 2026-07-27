package com.platzi.play;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final PlatziPlayAiServices aiServices;
    private final String plataform;

    public HelloController(@Value("${spring.application.name}") String plataform, PlatziPlayAiServices aiServices){
        this.plataform = plataform;
        this.aiServices = aiServices;
    }

    @GetMapping("")
    public String hello(){
        return this.aiServices.genereteGreeting(plataform);
    }
}
