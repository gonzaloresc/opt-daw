package com.examen.examen.model;

import com.examen.examen.categoria.Categoria;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Nuevo {

    private String nombre;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fecha;
    private String ubicacion;
    private Categoria categoria;
    private Integer plazasDisponibles;

    public Nuevo(String nombre, LocalDate fecha, String ubicacion, Categoria categoria, Integer plazasDisponibles) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.plazasDisponibles = plazasDisponibles;
    }

    public Nuevo() {}

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
