package com.actividad1.actividad1.service;

import com.actividad1.actividad1.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    Integer siguienteId = 1;
    List<Producto> productos = new ArrayList<>();

    public ProductoService (){
        productos.add(new Producto(siguienteId++,"Producto 1",0.8));
        productos.add(new Producto(siguienteId++,"Producto 2",4.0));
        productos.add(new Producto(siguienteId++,"Producto 3",8.9));
    }

    public List<Producto> obtenerTodos() {
        return productos;
    }

    public Optional<Producto> buscarId(Integer id){
        for (Producto p : productos){
            if(id.equals(p.getId())){
                return Optional.of(p); // Aqui se está devolviendo el que ha coincidido
            }
        }
        return Optional.empty();
    }

    public Producto crearProducto(){

        if (productos.size() >= 5){
            return null;
        }

        Producto pNuevo = new Producto(siguienteId,"Producto "+siguienteId, 5.0);
        productos.add(pNuevo);
        siguienteId++;
        return pNuevo;
    }

}


