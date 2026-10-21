package com.taquilla.taquilla.model;

public class Pelicula {

    private Integer id;
    private String titulo;
    private Double precioBase;
    private Integer asientos;

    public Pelicula(Integer id, String titulo, Double precioBase, Integer asientos) {
        this.id = id;
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.asientos = asientos;
    }

    public Pelicula(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public Integer getAsientos() {
        return asientos;
    }

    public void setAsientos(Integer asientos) {
        this.asientos = asientos;
    }
}
