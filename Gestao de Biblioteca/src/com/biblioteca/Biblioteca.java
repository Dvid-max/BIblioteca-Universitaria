package com.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Livro> emprestados = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void consultarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Lista vazia.");
            System.out.println("Deseja deseja saber se o livro existente no banco de dados digite '1'");
            String existente = sc.nextLine();
            if (existente.equals("1")) {
                System.out.println("Nome do livro: ");
                String nomeLivro = sc.nextLine();
                pesquisarEmprestado(nomeLivro);
            }
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
        if (livros.contains(livro)) {
            emprestados.add(livro);
            livros.remove(livro);
            System.out.println("Livro emprestado com sucesso.");
        } else {
            System.out.println("Livro não encontrado.");
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

    public void pesquisarEmprestado(String titulo) {
        boolean encontrado = false;
        for (Livro livro : emprestados) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(livro);
                System.out.println("Livro em uso por outro usuário");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado");
        }
    }


}

