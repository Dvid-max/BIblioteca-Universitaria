package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void consultarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Lista vazia.");
        } else {
            System.out.println("------------------------------------");
            System.out.println("Lista de Livros");
            System.out.println("------------------------------------");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println((i + 1) + " - " + livros.get(i));
            }
        }
    }

    public void excluirLivro(Livro livro) {
        livros.remove(livro);
    }
}
