package com.reto2.reto2.controller;

import com.reto2.reto2.model.Libro;
import com.reto2.reto2.model.Prestamo;
import com.reto2.reto2.model.Respuesta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @ResponseBody
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

        Integer diasTotales = prestamo.getDiasPrestamo();
        if (prestamo.getCarnetPremium()){
            diasTotales += 7;
        }
        LocalDate fechaDevolucion = LocalDate.now().plusDays(diasTotales);

        return new Respuesta(
                "CONCEDIDO",prestamo.getNombreSocio(),libroActual.getTitulo(),diasTotales,fechaDevolucion.toString()
        );
    }

    @GetMapping("/libros")
    @ResponseBody
    public List lista(
            @RequestParam(name="categoria", required = false) String categoria,
            @RequestParam(name="autor", required = false) String autor,
            @RequestParam(name="soloDisponibles", required = false, defaultValue = "false") Boolean soloDisponibles
            ){

        List<Libro> resultadoFiltrado = new ArrayList<>();

        for(Libro l : libros){
            Boolean dentro = true;

            if(categoria != null && !categoria.equalsIgnoreCase(l.getCategoria())){
                dentro = false;
            }
            if(autor != null && !autor.equalsIgnoreCase(l.getAutor())){
                dentro = false;
            }
            if(soloDisponibles && l.getEjemplaresDisponibles()<=0){
                dentro = false;
            }

            if (dentro){
                resultadoFiltrado.add(l);
            }
        }

        return resultadoFiltrado;
    }

    @GetMapping("/")
    public String inicio(){return "index";}


    @GetMapping("/libro")
    @ResponseBody
    public Object o (@RequestParam(name="id")Integer id){
        Libro libroSel = null;
        for(Libro l : libros){
            if(id.equals(l.getId())){
                libroSel = l;
            }
        }

        if(libroSel == null){
            return new Respuesta("RECHAZADO","Libro no encontrado");
        } else {
            return libroSel;
        }


    }


}
