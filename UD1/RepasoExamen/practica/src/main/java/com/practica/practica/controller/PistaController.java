package com.practica.practica.controller;

import com.practica.practica.model.Pista;
import com.practica.practica.model.Reserva;
import com.practica.practica.model.Respuesta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PistaController {

    List<Pista> pistas = new ArrayList<>(List.of(
            new Pista(101,"Pista Sur","Exterior",2.0,true),
            new Pista(102,"Pista Gym","Interior",3.0,true),
            new Pista(103,"Pista Baloncesto","Interior",3.5,false),
            new Pista(104,"Pista Norte","Exterior",1.0,true)
    ));

    @GetMapping("/reservar")
    public String reserva (){return ("reserva");}

    @PostMapping("/reservar")
    @ResponseBody
    public Respuesta respuesta(@ModelAttribute Reserva reserva){

        Pista pistaActual = null;
        for(Pista p : pistas){
            if(reserva.getPistaID() == p.getId()){
                pistaActual = p;
            }
        }
        if (pistaActual == null){
            return new Respuesta("RECHAZADO","Pista no encontrada");
        }
        if (!pistaActual.getDisponible()){
            return new Respuesta("RECHAZADO","Pista actualmente ocupada");
        }
        if (reserva.getHoras() < 1 || reserva.getHoras() > 4){
            return new Respuesta()
        }

    }


}
