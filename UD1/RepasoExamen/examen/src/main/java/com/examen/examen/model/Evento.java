package com.examen.examen.model;


import com.examen.examen.categoria.Categoria;

import java.time.LocalDate;
import java.util.Date;

public class Evento {

    private Long id;
    private String nombre;
    private LocalDate fecha;
    private String ubicacion;
    private Categoria categoria;
    private Integer plazasDisponibles;

    public Evento(Long id, String nombre, LocalDate fecha, String ubicacion, Categoria categoria, Integer plazasDisponibles) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.plazasDisponibles = plazasDisponibles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(Integer plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }
}
