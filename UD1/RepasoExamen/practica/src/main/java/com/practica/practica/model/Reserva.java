package com.practica.practica.model;

public class Reserva {

    private Integer pistaID;
    private String jugador;
    private Integer horas;
    private Boolean luzArtificial;

    public Reserva(Integer pistaID, String jugador, Integer horas, Boolean luzArtificial) {
        this.pistaID = pistaID;
        this.jugador = jugador;
        this.horas = horas;
        this.luzArtificial = luzArtificial;
    }

    public Reserva() {}

    public Integer getPistaID() {
        return pistaID;
    }

    public void setPistaID(Integer pistaID) {
        this.pistaID = pistaID;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Boolean getLuzArtificial() {
        return luzArtificial;
    }

    public void setLuzArtificial(Boolean luzArtificial) {
        this.luzArtificial = luzArtificial;
    }
}
