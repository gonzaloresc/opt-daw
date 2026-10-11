package com.actividad5.actividad5.controller;

import com.actividad5.actividad5.Pedido;
import com.actividad5.actividad5.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    @PostMapping("/pedido")
    public String nuevoPedido(
            @RequestBody Pedido pedido
        ) {

        String respuesta = "{ \"cliente\": \"";
        respuesta += pedido.getCliente().getNombre();
        respuesta += "\", \"totalProductos\": ";
        int cantidad = 0;
        double precioTotal = 0.0;

        for(Producto p : pedido.getProductos()) {
            cantidad += p.getCantidad();
            precioTotal += p.getCantidad() * p.getPrecioUnitario();
        }

        respuesta += cantidad;
        respuesta += ", \"precioTotal\": ";
        respuesta += precioTotal;
        respuesta += ", \"mensaje\": \"Pedido recibido correctamente\"}";

        return respuesta;

    }


}
