package com.Actividad2.Actividad2.model;

public class Libro {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anioPublicacion;
    private Boolean prestado;
    private String notasInternas;

    public Libro(Long id, String titulo, String autor, String isbn, Integer anioPublicacion, String notasInternas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.prestado = false;
        this.notasInternas = notasInternas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    // Prestar libros
    public boolean prestar(){
        if(prestado){
            return false;
        } else {
            prestado = true;
            return true;
        }
    }

    public boolean devolver(){
        if(!prestado){
            return false;
        } else {
            prestado = false;
            return true;
        }
    }

    public boolean getPrestado(){
        return prestado;
    }


    public String getNotasInternas() {
        return notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }
}
