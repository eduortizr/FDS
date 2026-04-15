package com.bcopstein.fds_spring_demo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AcervoFake implements IAcervo{
    @Override
    public List<Livro> todos() {
        List<Livro> livros = new LinkedList<>();
        livros.add(new Livro(10,"Criando livros Fake","Coringa",666));
        return livros;
    }

    @Override
    public List<Livro> livrosDoAno(int ano) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'livrosDoAno'");
    }

    @Override
    public List<Livro> livrosDoAnoAutor(int ano, String autor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'livrosDoAnoAutor'");
    }

    @Override
    public Livro novoLivro(Livro livro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'novoLivro'");
    }

}
