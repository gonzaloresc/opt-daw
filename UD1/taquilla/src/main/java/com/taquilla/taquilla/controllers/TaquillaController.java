package com.taquilla.taquilla.controllers;

import com.taquilla.taquilla.model.Pelicula;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TaquillaController {

    Pelicula[] peliculas = {
            new Pelicula(101,"La casa de Bernarda Alba", 25.0, 10),
            new Pelicula(102, "Yerma", 32.0, 5),
            new Pelicula(103, "El Tragaluz", 18.0, 20)
    };

    @GetMapping("/reserva")
    public String formularioRes() {return "formulario";}

    @GetMapping("/cartelera")
    @ResponseBody
    public List<Pelicula> consultarCartelera(
            @RequestParam(name="precioMax", required = false) Double precioMax,
            @RequestParam(name="soloDisponibles", required = false)
    )

}
