package com.biblioteca.services;

import com.biblioteca.models.Livro;

import java.util.ArrayList;
import java.util.List;
//Realiza operaões de cadastro, devolução e listagem de livros
public class Biblioteca {
    List<Livro> livros = new ArrayList<>();
    List<Livro> emprestados = new ArrayList<>();
    List<Cadastrado> emprestimos = new ArrayList<>();

    public void registrarEmprestimo(Cadastrado cadastrado) {
        emprestimos.add(cadastrado);
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum emprestimo registrado.");
        } else {
            for (Cadastrado cadastrado : emprestimos) {
                System.out.println(cadastrado);
            }
        }
    }

    public void realizarDevolucao(String tituloLivro) {
        for (Cadastrado emprestimo : emprestimos) {
            if (emprestimo.getLivro().getTitulo().equalsIgnoreCase(tituloLivro)) {
                emprestimo.getLivro().setDisponivel(true);
                emprestimos.remove(emprestimo);
                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado na lista de empréstimos.");
    }


    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros disponíveis");
        }
        int i = 0;
        for (Livro livro : livros) {
            System.out.println((i + 1) + " - " + livro);
            i++;
        }
    }

    public void realizarEmprestimo(int i) {
        emprestados.add(livros.get(i));
        livros.remove(i);
    }

    public void realizarDevolucao(int i) {
        Livro devolvido = emprestados.get(i);
        livros.add(devolvido);
        emprestados.remove(i);
    }


    public void listarEmprestados() {
        int i = 0;
        for (Livro livro : emprestados) {
            System.out.println((i + 1) + " - " + livro);
            i++;
        }
    }


    public void mostrarEmprestados(int i) {
        String nome_livro = livros.get(i).getTitulo();
        System.out.println((i + 1) + " - " + livros.get(i));
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public void listarLivrosDisponiveis() {
        System.out.println("Livros Disponíveis:");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
    }

    public void listarLivrosEmprestados() {
        System.out.println("Livros Emprestados:");
        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
    }

    public String listarEmprestimos(String usuario_nome, String livro_titulo, String emprestimo_data) {
        return "usuario: " + usuario_nome + ". " + "livro: " + livro_titulo + ". " + "data: " + emprestimo_data;
    }
}
