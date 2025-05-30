package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Livro> emprestados = new ArrayList<>();


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

    public void emprestimoDeLivro(Livro livro) {
        if (!livros.contains(livro)) {
            System.out.println("Livro não encontrado.");
        } else {
            emprestados.add(livro);
            livros.remove(livro);
            System.out.println("Livro emprestado com sucesso.");
        }


    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public void pesquisarLivro(String titulo2) {
        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo2)) {
                System.out.println(livro);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Livro não encontrado");
        }
    }




}

