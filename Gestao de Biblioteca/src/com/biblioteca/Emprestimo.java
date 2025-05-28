package com.biblioteca;

public class Emprestimo {
    private Livro livro;


    public  void realizarEmprestimo(Livro livro){
        livro.excluirLivro(livro);
        System.out.println("Emprestimo realizado com sucesso!");
    }

    public void adicinarLivro(Livro livro){
        livro.adicinarLivro(livro);
        System.out.println("Livro devolvido com sucesso!");
    }

}
