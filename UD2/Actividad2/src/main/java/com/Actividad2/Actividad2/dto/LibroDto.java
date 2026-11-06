package com.Actividad2.Actividad2.dto;

public class LibroDto {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anioPublicacion;
    private boolean prestado;

    public LibroDto(Long id, String titulo, String autor, String isbn, int anioPublicacion, boolean prestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.prestado = prestado;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }
}
