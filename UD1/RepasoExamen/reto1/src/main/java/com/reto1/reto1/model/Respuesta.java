package com.reto1.reto1.model;

public class Respuesta {

    private String estado;
    private String error;
    private String cliente;
    private Integer entradas;
    private Double precioUnitario;
    private Double subtotal;
    private Double descuentoTotal;
    private Double totalAPagar;


    public Respuesta(String estado, String error) {
        this.estado = estado;
        this.error = error;
    }

    public Respuesta(String estado, String cliente, Integer entradas, Double precioUnitario, Double subtotal, Double descuentoTotal, Double totalAPagar) {
        this.estado = estado;
        this.cliente = cliente;
        this.entradas = entradas;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuentoTotal = descuentoTotal;
        this.totalAPagar = totalAPagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getEntradas() {
        return entradas;
    }

    public void setEntradas(Integer entradas) {
        this.entradas = entradas;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(Double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(Double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
