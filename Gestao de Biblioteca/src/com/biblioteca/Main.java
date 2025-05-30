package com.biblioteca;

import java.util.Scanner;
import java.util.function.ObjIntConsumer;

public class Main {
    public static void main(String[] args) {
        //Concertar main, criando o objeto biblioteca fora do case e mudando os atributos do livro sem usar set
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int resposta = -1;
        int resposta2 = -1;
       do {
           System.out.println("-------------------------------");
           System.out.println("Biblioteca Acadêmica");
           System.out.println("-------------------------------");
           System.out.println("Digite '1' para cadastrar um livro");
           System.out.println("Digite '2' para cadastrar um usuário");
           System.out.println("Digite '3' para consultar disponibilidade de livro");
           System.out.println("Digite '4' para listar livros");
           System.out.println("Digite '5' para devolver livros");
           System.out.println("Digite '6' para pegar livros emprestados");
           System.out.println("Digite '0' para sair da Biblioteca");

           resposta = sc.nextInt();
           sc.nextLine();

           switch (resposta) {
               //CADASTRO DE LIVROS
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
                   sc.nextLine();
                   System.out.print("Editora: ");
                   String editora = sc.nextLine();

                   //Criando objeto
                   Livro livro =  new Livro(titulo, autor, isbn, ano, editora);
                   //Cadastrando Livro na Biblioteca
                   biblioteca.cadastrarLivro(livro);

                   break;
               //CADASTRO DE USUARIOS
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
               //PESQUISAR LIVROS
               case 3:
                   do {
                       System.out.println("Digite '1' para listar livros disponíves");
                       System.out.println("Digite '2' para pesquisar livros disponíves");
                       System.out.println("Digite '0' para sair.");
                       resposta2= sc.nextInt();
                       sc.nextLine();
                       if (resposta2==1) {
                           //Listar livros
                           biblioteca.consultarLivros();
                       }else if (resposta2==2) {
                           //Consultar livros
                           System.out.println("Nome: ");
                           String titulo2 = sc.nextLine();
                           biblioteca.pesquisarLivro(titulo2);
                       }else;
                   }while (resposta2 != 0);
                   break;
               case 4:
                   System.out.println("Livros listados com sucesso!");
                   break;
               case 5:
                   System.out.println("Em andamento");
                   break;
               case 6:
                   System.out.print("Nome do livro: ");
                   String nome_livro = sc.nextLine();
                   Livro livroParaEmprestar = biblioteca.buscarLivroPorTitulo(nome_livro);
                   if (livroParaEmprestar == null) {
                       System.out.println("Livro não encontrado!");
                   }else {
                       biblioteca.emprestimoDeLivro(livroParaEmprestar);
                       System.out.println("Emprestimo realizado com sucesso!");
                   }
                   break;
           }


       }while (resposta!=0);
    }
}
