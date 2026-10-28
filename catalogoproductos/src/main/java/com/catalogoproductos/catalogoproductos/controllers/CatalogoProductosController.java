package com.catalogoproductos.catalogoproductos.controllers;

import com.catalogoproductos.catalogoproductos.model.Producto;
import com.catalogoproductos.catalogoproductos.model.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogoProductosController {

    private final List<Producto> productos = new ArrayList<>();



    CatalogoProductosController(){
        productos.add(new Producto(1, 20.00, "producto1"));
        productos.add(new Producto(2, 20.00, "producto2"));
        productos.add(new Producto(3, 20.00, "producto3"));

    }





    @GetMapping("/productos")
    public ResponseEntity<?> listar() {

        if(productos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Respuesta("No hay productos"));
        } else {
            return ResponseEntity.ok(productos);
        }
    }

//    @GetMapping("/productos/buscar")
//    public ResponseEntity<?> respuesta (@RequestParam Integer id){
//        for (Producto p : productos){
//
//        }
//    }

    @GetMapping("/productos/resumen")
    public ResponseEntity<?> resumen() {

        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new Respuesta("Hay "+ productos.toArray().length+ " productos"));
    }

}
