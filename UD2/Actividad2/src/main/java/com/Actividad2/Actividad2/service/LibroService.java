package com.Actividad2.Actividad2.service;


import com.Actividad2.Actividad2.dto.CrearLibroDto;
import com.Actividad2.Actividad2.dto.LibroDto;
import com.Actividad2.Actividad2.dto.LibroResumenDto;
import com.Actividad2.Actividad2.model.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    Long siguienteId = 1L;
    List<Libro> libros = new ArrayList<>();

    public LibroService () {
        libros.add (new Libro(siguienteId++,"El Quijote","Miguel de Cervantes","978-84-376-0494-7",1605,null));
        libros.add (new Libro(siguienteId++,"Ejemplo2","Autor2","000-00-000-0000-0",2000,"Este es una caso de prueba"));
        libros.add (new Libro(siguienteId++,"Ejemplo3","Autor3","000-00-000-0000-1",2003,"Seguro que se presta pronto"));
    }

    public List<LibroResumenDto> libros (){

        List<LibroResumenDto> librosResumen = new ArrayList<>();

        for (Libro l : libros){
            librosResumen.add (new LibroResumenDto(l.getId(),l.getTitulo()));
        }
        return librosResumen;
    }

    public Optional<LibroDto> buscar (Long id){
        for (Libro l : libros){
            if(id.equals(l.getId())){
                return Optional.of(new LibroDto(l.getId(),l.getTitulo(),l.getAutor(),l.getIsbn(),l.getAnioPublicacion(),l.getPrestado()));
            }
        }
        return Optional.empty();
    }

    public LibroDto crearLibro (CrearLibroDto cLibro){

        if(cLibro.getTitulo() == null || cLibro.getAutor() == null || cLibro.getAnioPublicacion() <= 0){
            throw new IllegalArgumentException("Datos invalidos");
        }

        for (Libro l : libros){
            if(cLibro.getIsbn().equals(l.getIsbn())){
                throw new IllegalStateException("Hay otro libro con el mismo ISBN");
            }
        }

        Long idActual = siguienteId++;

        libros.add(new Libro(idActual,cLibro.getTitulo(),cLibro.getAutor(),cLibro.getIsbn(),cLibro.getAnioPublicacion(),null));

        return new LibroDto(idActual,cLibro.getTitulo(),cLibro.getAutor(),cLibro.getIsbn(),cLibro.getAnioPublicacion(),false);

    }

    public LibroDto prestar (Long id){

        for (Libro l : libros){
            if(id.equals(l.getId())){
                if(!l.prestar()){
                    throw new IllegalStateException("El libro ya está prestado");
                } else {
                    return new LibroDto(l.getId(),l.getTitulo(),l.getAutor(),l.getIsbn(),l.getAnioPublicacion(),l.getPrestado());
                }
            }
        }
        throw new IllegalArgumentException("El libro no existe");
    }

    public LibroDto devolver (Long id){
        for (Libro l : libros){
            if(id.equals(l.getId())){
                if(!l.devolver()){
                    throw new IllegalStateException("El libro no estaba prestado");
                } else {
                    return new LibroDto(l.getId(),l.getTitulo(),l.getAutor(),l.getIsbn(),l.getAnioPublicacion(),l.getPrestado());
                }
            }
        }
        throw new IllegalArgumentException("El libro no existe");
    }


}
