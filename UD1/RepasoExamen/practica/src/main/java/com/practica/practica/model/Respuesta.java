package com.practica.practica.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Respuesta {

    private String estado;
    private String jugador;
    private String pista;
    private Double totalPagar;
    private String motivo;

    public Respuesta(String estado, String jugador, String pista, Double totalPagar) {
        this.estado = estado;
        this.jugador = jugador;
        this.pista = pista;
        this.totalPagar = totalPagar;
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

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getPista() {
        return pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
