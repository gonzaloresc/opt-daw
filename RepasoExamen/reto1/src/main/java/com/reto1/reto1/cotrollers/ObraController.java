package com.reto1.reto1.cotrollers;

import com.reto1.reto1.model.Obra;
import com.reto1.reto1.model.Reserva;
import com.reto1.reto1.model.Respuesta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ObraController {

    List<Obra> cartelera = new ArrayList<>(List.of(
            new Obra(101,"La Casa de Bernarda Alba", 25.0, 10),
            new Obra(102,"Yerma",32.0,5),
            new Obra(103,"El tragaluz",18.0,20)
    ));

    @GetMapping("/reservar")
    public String reserva(){
        return "reserva";
    }

    @PostMapping("/reservar")
    @ResponseBody
    public Respuesta procesarReserva (@ModelAttribute Reserva reserva){

        Obra obraActual = null;
        for (Obra o : cartelera){
            if ( o.getId() == reserva.getEventoId() ) {
                obraActual = o;
                break;
            }
        }

        if (obraActual == null ){
            return new Respuesta("RECHAZADA","La obra no existe");
        }

        if(reserva.getCantidad() > obraActual.getAsientos()){
            return new Respuesta("RECHAZADA","No hay asientos suficientes, quedan " + obraActual.getAsientos());
        }

        obraActual.setAsientos(obraActual.getAsientos() - reserva.getCantidad());

        Double precioUnitario = obraActual.getPrecioBase();
        if("vip".equals(reserva.getTipoEntrada())){
            precioUnitario = precioUnitario * 1.20;
        }

        Double subtotal = precioUnitario * reserva.getCantidad();
        Double descuento = 0.0;

        if(reserva.getCantidad() >= 4){
            descuento += subtotal * 0.10;
        }


        Double descuentoTotal = descuento * reserva.getCantidad();


        Double totalDps = subtotal - descuentoTotal;

        if("DESCUENTO15".equals(reserva.getCodigoCupon())){
            descuentoTotal += totalDps * 0.15;
        }

        Double totalAPagar = subtotal - descuentoTotal;

        return new Respuesta(
                "CONFIRMADA",
                reserva.getNombreCliente(),
                reserva.getCantidad(),
                obraActual.getPrecioBase(),
                subtotal,
                descuentoTotal,
                totalAPagar
        );

    }

}
