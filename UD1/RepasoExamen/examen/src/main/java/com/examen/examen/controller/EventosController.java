package com.examen.examen.controller;

import com.examen.examen.categoria.Categoria;
import com.examen.examen.model.Evento;
import com.examen.examen.model.MensajeError;
import com.examen.examen.model.Nuevo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EventosController {

    private List<Evento> eventos = new ArrayList<>();
    private Long siguienteId = 1L;

    public EventosController (){
        eventos.add(new Evento(siguienteId++,"Concierto",LocalDate.now().plusDays(30), "Auditorio",Categoria.MUSICA, 200));
        eventos.add(new Evento(siguienteId++,"Teatro",LocalDate.now().plusDays(30), "Teatro",Categoria.CULTURA, 200));
        eventos.add(new Evento(siguienteId++,"Concierto",LocalDate.now().plusDays(30), "Auditorio",Categoria.MUSICA, 200));
    }


    @GetMapping("/eventos")
    @ResponseBody
    public String eventos(){

        String respuesta = "<table border=1>";
        Evento eventoActual = null;

        for(Evento e : eventos){
            eventoActual = e;
            respuesta+= "<tr> <td>"+e.getId()+"</td> <td>"+e.getNombre()+"</td> <td>"+e.getFecha()+"</td> <td>"+e.getUbicacion()+"</td> <td>"+e.getCategoria()+"</td> <td>"+e.getPlazasDisponibles()+"</td> </tr>";
        }
        respuesta += "</table>";

        if(eventoActual == null){
            return "No hay eventos";
        } else {
            return respuesta;
        }
    }

    @GetMapping("/nuevo.html")
    public String nuevo(){ return "nuevo"; }

    @PostMapping("/eventos")
    @ResponseBody
    public String resultado(@ModelAttribute Nuevo form){

        String errores = "";
        String html = "";

        if(form.getNombre() == null || form.getNombre().length() < 3){
            errores += "El nombre debe tener más de 2 carácteres ";
        }

        if(form.getFecha() == null || form.getFecha().isBefore(LocalDate.now())){
            errores += "La fecha debe ser no anterior a hoy ";
        }

        if(form.getUbicacion() == null){
            errores += "La ubicación es obligatoria ";
        }

        if(form.getCategoria() == null){
            errores += "La categoría es obligatoria ";
        }

        if(form.getPlazasDisponibles() == null){
            errores += "Debes poner plazas ";
        }

        if(form.getPlazasDisponibles() < 1 || form.getPlazasDisponibles() > 500){
            errores += "Las plazas deben entrar en el rango (1-500)";
        }

        if(errores == ""){
            eventos.add(new Evento(siguienteId, form.getNombre(), form.getFecha(), form.getUbicacion(),form.getCategoria(), form.getPlazasDisponibles()));

            html+= "<table> <td>"+siguienteId+"</td> <td>"+form.getNombre()+"</td> <td>"+form.getFecha()+"</td> <td>"+form.getUbicacion()+"</td> <td>"+form.getCategoria()+"</td> <td>"+form.getPlazasDisponibles()+"</td> </table>";
            return html;
        } else {
            return errores;
        }
    }

    @GetMapping("/api/evento")
    @ResponseBody
    public Object object(@RequestParam Long id){

        Evento eventoActual = null;

        for(Evento e : eventos) {
            if(id.equals(e.getId())){
                eventoActual = e;
            }
        }

        if(eventoActual == null){
            return new MensajeError("Evento no encontrado");
        } else {
            return eventoActual;
        }
    }

    @GetMapping("/eventos/eliminar")
    public String eliminar (@RequestParam Long id){

        Evento eventoActual = null;

        for(Evento e : eventos) {
            if(id.equals(e.getId())){
                eventos.remove(e);
            }
        }
        return "/eventos";
    }

}
