package com.actividad3.actividad3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Actividad3Controller {

    @GetMapping("/elegir")
    public String elegir(@RequestParam(name = "idioma", required = false, defaultValue = "english") String idioma){

        return switch (idioma){
            case "spanish" -> "redirect:/spanish.html";
            case "french" -> "redirect:/french.html";
            case "english" -> "redirect:/english.html";
            case "german" -> "redirect:/german.html";
            default -> "redirect:/english.html";
        };

    }

}
