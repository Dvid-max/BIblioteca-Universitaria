package com.biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resposta = -1;
       do {
           System.out.println("-------------------------------");
           System.out.println("Biblioteca Acadêmica");
           System.out.println("-------------------------------");
           System.out.println("Digite '1' para cadastrar um livro");
           System.out.println("Digite '2' para cadastrar um usuário");
           System.out.println("Digite '3' para consultar disponibilidade de livro");
           System.out.println("Digite '4' para listar livros");
           System.out.println("Digite '0' para sair da Biblioteca");

           resposta = sc.nextInt();
           sc.nextLine();

           switch (resposta) {
               case 1:
                   //Pegando dados do livro
                   System.out.println("------------------");
                   System.out.println("Cadastro de livro");
                   System.out.println("------------------");
                   System.out.print("Título: ");
                   String titulo = sc.nextLine();
                   System.out.print("Autor: ");
                   String autor = sc.nextLine();
                   System.out.print("ISBN: ");
                   String isbn = sc.nextLine();
                   System.out.print("Ano: ");
                   int ano = sc.nextInt();
                   System.out.print("Editora: ");
                   String editora = sc.nextLine();

                   //Criando objeto
                   Livro livro = new Livro(titulo, autor, isbn, ano, editora);
                   //Cadastrando Livro
                   livro.cadastrarLivro(livro);
                   System.out.println("Livro cadastrado com sucesso!");
                   break;
               case 2:
                   System.out.println("------------------");
                   System.out.println("Cadastro de Usuário");
                   System.out.println("------------------");
                   System.out.print("Nome: ");
                   String nome = sc.nextLine();
                   System.out.print("Matrícula: ");
                   String matricula = sc.nextLine();
                   System.out.print("Tipo(Aluno ou Professor): ");
                   String tipo = sc.nextLine();
                   System.out.print("cpf");
                   String cpf = sc.nextLine();
                   System.out.print("e-mail");
                   String email = sc.nextLine();

                   Usuario usuario = new Usuario(nome, matricula, tipo, cpf, email);


                   if (tipo.equals("Professor")) {
                       Professor professor = new Professor(usuario);
                       professor.cadastrarUsuario(professor);
                       System.out.println("Professor cadastrado com sucesso!");
                   }else if (tipo.equals("Aluno")) {
                       Aluno aluno = new Aluno(usuario);
                       aluno.cadastrarUsuario(aluno);
                       System.out.println("Aluno cadastrado com sucesso!");
                   }else {
                       System.out.println("Erro ao efeturar cadastro.");
                       System.out.println("Digite somente 'Professor' ou 'Aluno'.");
                   }
                   break;
               case 3:

                   System.out.println("Livros consultados com sucesso!");
                   break;
               case 4:
                   System.out.println("Livros listados com sucesso!");
                   break;
           }


       }while (resposta!=0);
    }
}
