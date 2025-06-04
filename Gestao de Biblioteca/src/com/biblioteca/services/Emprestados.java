package com.biblioteca.services;

import com.biblioteca.models.Livro;

public class Emprestados extends Livro {

    public Emprestados(String titulo, String autor, String isbn, int ano, String editora){
        super( titulo,autor,isbn, ano, editora);
    }


}
