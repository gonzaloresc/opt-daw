package com.Actividad2.Actividad2.controller;


import com.Actividad2.Actividad2.dto.CrearLibroDto;
import com.Actividad2.Actividad2.dto.ErrorDto;
import com.Actividad2.Actividad2.dto.LibroDto;
import com.Actividad2.Actividad2.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibroController {

    private final LibroService libroService;
    public LibroController (LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/libros")
    public ResponseEntity<?> libros (){
        return ResponseEntity.ok(libroService.libros());
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<?> buscar (@PathVariable Long id){
        if (libroService.buscar(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("Libro no encontrado"));
        }
        return ResponseEntity.ok(libroService.buscar(id));
    }

    @PostMapping("/libros")
    public ResponseEntity<?> crear (@RequestBody CrearLibroDto cLibro){
        try {
            LibroDto nuevoLibro = libroService.crearLibro(cLibro);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDto(e.getMessage()));
        } catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDto(e.getMessage()));
        }
    }

    @PostMapping("/libros/{id}/prestamo")
    public ResponseEntity<?> prestar (@PathVariable Long id){
        try {
            LibroDto prestado = libroService.prestar(id);
            return ResponseEntity.ok(prestado);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
        } catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDto(e.getMessage()));
        }
    }

    @PostMapping("/libros/{id}/devolucion")
    public ResponseEntity<?> devolver (@PathVariable Long id){
        try {
            LibroDto devuelto = libroService.devolver(id);
            return ResponseEntity.ok(devuelto);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto(e.getMessage()));
        } catch (IllegalStateException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorDto(e.getMessage()));
        }
    }

}
