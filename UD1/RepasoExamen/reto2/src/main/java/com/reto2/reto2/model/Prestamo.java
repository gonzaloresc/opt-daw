package com.reto2.reto2.model;

public class Prestamo {

    private Integer libroId;
    private String nombreSocio;
    private Integer diasPrestamo;
    private Boolean carnetPremium = false;

    public Prestamo(Integer libroId, String nombreSocio, Integer diasPrestamo, Boolean carnetPremium) {
        this.libroId = libroId;
        this.nombreSocio = nombreSocio;
        this.diasPrestamo = diasPrestamo;
        this.carnetPremium = carnetPremium;
    }

    public Prestamo() {}

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public Integer getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(Integer diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public Boolean getCarnetPremium() {
        return carnetPremium;
    }

    public void setCarnetPremium(Boolean carnetPremium) {
        this.carnetPremium = carnetPremium;
    }
}
