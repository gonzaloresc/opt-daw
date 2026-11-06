package com.practica.practica.model;

public class Pista {

    private Integer id;
    private String nombre;
    private String tipo;
    private Double precioHora;
    private Boolean disponible;

    public Pista(Integer id, String nombre, String tipo, Double precioHora, Boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioHora = precioHora;
        this.disponible = disponible;
    }

    public Pista() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(Double precioHora) {
        this.precioHora = precioHora;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
