package com.bcopstein.fds_spring_demo;

import java.util.List;

public interface IAcervo {

    List<Livro> todos();

    List<Livro> livrosDoAno(int ano);

    List<Livro> livrosDoAnoAutor(int ano, String autor);

    Livro novoLivro(Livro livro);

}