package com.bcopstein.fds_spring_demo;

public class Livro {
    private long id;
    private String titulo;
    private String autor;
    private int ano;

    public Livro(long id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }
}
