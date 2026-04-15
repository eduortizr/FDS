package com.bcopstein.fds_spring_demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private List<Livro> livros;

    public Controller(){
        livros = new ArrayList<>();
        livros.add(new Livro(10,"Aprendendo Spring-Boot em 10 licoes","Huguinho Pato",2023));
        livros.add(new Livro(10,"Aprendendo NodeJS em 10 licoes","Huguinho Pato",2025));
        livros.add(new Livro(10,"Aprendendo DotNet em 10 licoes","Luizinho Pato",2023));
        livros.add(new Livro(10,"Aprendendo Go em 10 licoes","Luizinho Pato",2026));
    }

    @GetMapping("")
    @CrossOrigin("*")
    public String welcomeMessage(){
        return "Bem vindo a Biblioteca Central";
    }

    @GetMapping("/livros")
    @CrossOrigin("*")
    public List<Livro> listaDeLivros(){
        return livros;
    }

    @GetMapping("/livrosDoAno")
    @CrossOrigin("*")
    public List<Livro> livrosDoAno(@RequestParam(value="ano")int ano){
        return livros.stream()
            .filter(livro->livro.getAno() == ano)
            .toList();
    }


}
