package com.platzi.play;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final PlatziPlayAiServices aiServices;

    public HelloController(PlatziPlayAiServices aiServices){
        this.aiServices = aiServices;
    }

    @GetMapping("")
    public String hello(){
        return this.aiServices.genereteGreeting();
    }
}
