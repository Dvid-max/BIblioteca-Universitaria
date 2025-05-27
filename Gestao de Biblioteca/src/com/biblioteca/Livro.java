package com.biblioteca;

import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int ano;
    private String editora;
    List<Livro> livros;

    public Livro(String titulo, String autor, String isbn, int ano, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
    }


    public void cadastrarLivro(Livro livro){
        livros.add(livro);
    }

    public void consultarLivro(Livro livro){
        if (livros.isEmpty()){
            System.out.println("Lista vazia.");
        }else{
            System.out.println("------------------------------------");
            System.out.println("Lista de Livros");
            System.out.println("------------------------------------");
            for (int i = 0; i < livros.size(); i++){
                System.out.println((i+1) + " - " + livros.get(i));
            }
        }
    }

}
