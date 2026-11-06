package com.reto2.reto2.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Respuesta {

    private String estado;
    private String motivo;
    private String socio;
    private String libro;
    private Integer diasTotales;
    private String fechaDevolucion;

    public Respuesta(String estado, String socio, String libro, Integer diasTotales, String fechaDevolucion) {
        this.estado = estado;
        this.socio = socio;
        this.libro = libro;
        this.diasTotales = diasTotales;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Respuesta(String estado, String motivo) {
        this.estado = estado;
        this.motivo = motivo;
    }

    public Respuesta() {}

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public Integer getDiasTotales() {
        return diasTotales;
    }

    public void setDiasTotales(Integer diasTotales) {
        this.diasTotales = diasTotales;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
