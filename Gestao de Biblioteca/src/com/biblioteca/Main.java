package com.biblioteca;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //DECLARANDO VARIAVEIS
        int resposta = -1;

        //CRIANDO OBJERTOS
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        do {
            System.out.println("-------------------");
            System.out.println("BIBLIOTECA");
            System.out.println("-------------------");
            // ✅ Cadastro de livros: título, autor, ISBN, ano e editora.
            System.out.println("Digite '1' para cadastrar um livro");

            //✅ Cadastro de usuários: nome, matrícula, tipo (aluno ou professor), CPF e e-mail.
            System.out.println("Digite '2' para cadastrar um usuário");

            //✅ Consulta de disponibilidade de livros.
            System.out.println("Digite '3' para consultar a disponibilidade de um livro");

            //✅ Empréstimos: número do empréstimo, usuário, livro(s), data e status do empréstimo.
            System.out.println("Digite '4' para realizar um emprestimo");

            //✅ Devolução de livros: atualização do status do empréstimo e da disponibilidade do exemplar.
            System.out.println("Digite '5' para devolver um livro");

            //✅ Listagem de livros: ISBN, título, autor, editora e status (disponível ou emprestado).
            System.out.println("Digite '6' para listar livros");
            System.out.println("Digite '0' para sair");

            resposta = sc.nextInt();
            sc.nextLine();

            switch (resposta) {
                case 1:
                    System.out.println("CADASTRO DE LIVROS");
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Isbn: ");
                    String isbn = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Editora: ");
                    String editora = sc.nextLine();

                    Livro livro = new Livro(titulo, autor, isbn, ano, editora);
                    biblioteca.cadastrarLivro(livro);
                    System.out.println("Livro cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("CADASTRO DE USUARIOS");
                    System.out.println("Nome: ");
                    String nome = sc.nextLine();
                    System.out.println("Matricula: ");
                    String matricula = sc.nextLine();
                    System.out.println("Tipo (Aluno ou Professor): ");
                    String tipo = sc.nextLine();
                    System.out.println("Cpf: ");
                    String cpf = sc.nextLine();
                    System.out.println("Email: ");
                    String email = sc.nextLine();

                    Usuario usuario = new Usuario(nome, matricula, tipo, cpf, email);

                    //Criando uma estrutura de controle para saber se o usuário é aluno ou professor
                    if (tipo.equalsIgnoreCase("Professor")) {
                        Professor professor = new Professor(usuario);
                        professor.cadastrarUsuario(usuario);
                        System.out.println("Professor Cadastrado com sucesso!");
                    }else if (tipo.equalsIgnoreCase("Aluno")) {
                        Aluno aluno = new Aluno(usuario);
                        aluno.cadastrarUsuario(usuario);
                        System.out.println("Aluno Cadastrado com sucesso!");
                    }else {
                        System.out.println("Tipo inserido invalido!");
                        System.out.println("Digite somente Aluno ou Professor");
                    }
                    break;
                case 3:
                    System.out.println("DISPONIBILIDADE DE LIVROS");
                    biblioteca.listarLivros();
                    break;
                case 4:
                    System.out.println("REALIZAR EMPRESTIMOS");
                    System.out.println("LIVROS DISPONIVEIS");
                    biblioteca.listarLivros();
                    System.out.println("Digite apenas o número do livro que deseja realizar um emprestimo: ");
                    int emprestimo = sc.nextInt();
                    sc.nextLine();
                    biblioteca.realizarEmprestimo(emprestimo - 1);
                    System.out.println("Emprestimo realizado com sucesso!");
                    break;
                case 5:
                    System.out.println("DEVOLUÇÃO DE LIVROS");
                    System.out.print("Título: ");
                    String titulo2 = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor2 = sc.nextLine();
                    System.out.print("Isbn: ");
                    String isbn2 = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Editora: ");
                    String editora2 = sc.nextLine();

                    Livro livro2 = new Livro(titulo2, autor2, isbn2, ano2, editora2);
                    biblioteca.cadastrarLivro(livro2);
                    System.out.println("Livro devolvido com sucesso.");
                    break;
                case 6:
                    System.out.println("TOTAL DE LIVROS");
                    System.out.println("Livros diponíves");
                    biblioteca.listarLivros();
                    System.out.println("Livros emprestados");
                    biblioteca.listarEmprestados();
                    System.out.println("------------------------------");
                break;
            }

        }while (resposta != 0);

    }
}