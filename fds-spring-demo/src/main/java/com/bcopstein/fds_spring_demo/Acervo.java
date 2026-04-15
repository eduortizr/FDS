package com.bcopstein.fds_spring_demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Acervo implements IAcervo {
    private List<Livro> livros;

    public Acervo() {
        livros = new ArrayList<>();
        livros.add(new Livro(10, "Aprendendo Spring-Boot em 10 licoes", "Huguinho Pato", 2023));
        livros.add(new Livro(10, "Aprendendo NodeJS em 10 licoes", "Huguinho Pato", 2025));
        livros.add(new Livro(10, "Aprendendo DotNet em 10 licoes", "Luizinho Pato", 2023));
        livros.add(new Livro(10, "Aprendendo Go em 10 licoes", "Luizinho Pato", 2026));
    }

    @Override
    public List<Livro> todos() {
        return livros;
    }

    @Override
    public List<Livro> livrosDoAno(int ano) {
        return livros.stream()
                .filter(livro -> livro.getAno() == ano)
                .toList();
    }

    @Override
    public List<Livro> livrosDoAnoAutor(int ano, String autor) {
        return livros.stream()
                .filter(livro -> livro.getAno() == ano)
                .filter(livro -> livro.getAutor().equals(autor))
                .toList();
    }

    @Override
    public Livro novoLivro(Livro livro) {
        livros.add(livro);
        return livros.getLast();
    }
}
