package com.reto2.reto2.controller;

import com.reto2.reto2.model.Libro;
import com.reto2.reto2.model.Prestamo;
import com.reto2.reto2.model.Respuesta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PrestamoController {

    List<Libro> libros = new ArrayList<>(List.of(
            new Libro(101,"Libro 1","Gonzalo","terror",2),
            new Libro(102,"Libro 2","socrates","fantasia",5),
            new Libro(103,"Libro 3","Maria","romance",6),
            new Libro(104,"Libro 4","Gonzalo","historia",4),
            new Libro(105,"Libro 5","socrates","romance",0)
    ));

    @GetMapping("/prestamo")
    public String prestamo(){
        return "prestamo";
    }

    @PostMapping("/prestamo")
    public Respuesta respuesta(@ModelAttribute Prestamo prestamo){

        Libro libroActual = null;

        for(Libro l : libros){
            if(l.getId() == prestamo.getLibroId()){
                libroActual = l;
            }
        }

        if(libroActual == null){
            return new Respuesta("RECHAZADO","Libro no encontrado");
        }

        if(libroActual.getEjemplaresDisponibles() < 1 ){
            return new Respuesta("RECHAZADO","Sin ejemplares disponibles");
        }

        if(prestamo.getDiasPrestamo() < 1 || prestamo.getDiasPrestamo() > 30 ){
            return new Respuesta("RECHAZADO","Duracion no valida (1-30 dias)");
        }

        libroActual.setEjemplaresDisponibles( libroActual.getEjemplaresDisponibles() - 1 );





    }


}
