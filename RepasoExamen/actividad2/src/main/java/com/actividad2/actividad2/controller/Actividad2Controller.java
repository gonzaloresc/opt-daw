package com.actividad2.actividad2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Actividad2Controller {

    @GetMapping("/inicio")
    public String pInicio (){
        String message = "<h1>Bienvenido a la aplicación<h1>";
        message += "<p>hohlhohohohohohohohohohohohohohohohoh</p>";
        return message;
    }

    @GetMapping("/contacto")
    public String pContacto (){
        String message = "<h1>Página de contacto<h1>";
        message += "<p>hohlhohohohohohohohohohohohohohohohoh</p>";
        return message;
    }

}
