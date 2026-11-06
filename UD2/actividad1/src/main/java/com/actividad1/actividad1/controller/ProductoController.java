package com.actividad1.actividad1.controller;

import com.actividad1.actividad1.model.Producto;
import com.actividad1.actividad1.model.Respuesta;
import com.actividad1.actividad1.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductoController {

    private final ProductoService productoService;
    public ProductoController (ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public ResponseEntity<?> productos () {

        List<Producto> lista = productoService.obtenerTodos();

        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Respuesta("No hay productos"));
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/productos/buscar")
    public ResponseEntity<?> (@RequestParam Integer id){


    }


}
