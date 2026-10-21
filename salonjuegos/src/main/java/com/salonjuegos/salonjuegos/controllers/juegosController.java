package com.salonjuegos.salonjuegos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/juegos")
public class juegosController {

    @GetMapping("/dados")
    public String dados(
            @RequestParam(name="cantidad", required = false, defaultValue = "2") Integer cantidad,
            @RequestParam(name="caras", required = false, defaultValue = "6") Integer caras
    ){

        if (cantidad < 1 || cantidad > 10){
            return "La cantidad debe estar entre 1 y 10";
        }

        ArrayList<Integer> carasV = new ArrayList<>(List.of(4, 6, 8, 10, 12, 20));

        if (!carasV.contains(caras)){
            return "Las caras deben ser 4, 6, 8, 10, 12 o 20";
        }

        ArrayList<Integer> resultados = new ArrayList<>();
        Random rand = new Random();
        Integer prim;

        for (int i = 1; i <= cantidad; i++){
            if(i == 1){
                prim = rand.nextInt(caras -1) +1;
                resultados.add(prim);
            } else {
                resultados.add(rand.nextInt(caras -1) +1);
            }
        }



    }

}
