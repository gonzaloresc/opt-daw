package com.actividad6.actividad6.model;

public class Formulario {
    private String nombre;
    private String apellidos;
    private String correo;
    private Integer contrasena;


    public Formulario() {
    }

    public Formulario(String nombre, String apellidos, String correo, Integer contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public Integer getContrasena() { return contrasena; }
    public void setContrasena(Integer contrasena) { this.contrasena = contrasena; }

}