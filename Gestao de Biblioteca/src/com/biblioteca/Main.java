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
        Usuario usuario = new Usuario();
        Professor professor = new Professor();
        Aluno aluno = new Aluno();


        do {
            System.out.println("-------------------");
            System.out.println("BIBLIOTECA");
            System.out.println("-------------------");
            // ✅ Cadastro de livros: título, autor, ISBN, ano e editora.
            System.out.println("Digite '1' para cadastrar um livro");

            //✅ Cadastro de usuários: nome, matrícula, tipo (aluno ou professor), CPF e e-mail.
            System.out.println("Digite '2' para cadastrar um usuário");

            //✅ Consulta de disponibilidade de livros.
            //✅ Listagem de livros: ISBN, título, autor, editora e status (disponível ou emprestado).
            System.out.println("Digite '3' para consultar a disponibilidade de um livro");

            //✅ Empréstimos: número do empréstimo, usuário, livro(s), data e status do empréstimo.
            System.out.println("Digite '4' para realizar um emprestimo");

            //✅ Devolução de livros: atualização do status do empréstimo e da disponibilidade do exemplar.
            System.out.println("Digite '5' para devolver um livro");


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
                    usuario.setNome(sc.nextLine());
                    System.out.println("Matricula: ");
                    usuario.setMatricula(sc.nextLine());
                    System.out.println("Tipo (Aluno ou Professor): ");
                    usuario.setTipo(sc.nextLine());
                    System.out.println("Cpf: ");
                    usuario.setCpf(sc.nextLine());
                    System.out.println("Email: ");
                    usuario.setEmail(sc.nextLine());


                    //Criando uma estrutura de controle para saber se o usuário é aluno ou professor
                    if (usuario.getTipo().equalsIgnoreCase("Professor")) {
                        Professor novoProfessor = new Professor(usuario.getNome(), usuario.getMatricula(), usuario.getTipo(), usuario.getCpf(), usuario.getEmail());
                        professor.cadastrarUsuario(novoProfessor);
                        System.out.println("Professor Cadastrado com sucesso!");
                        professor.listarProfessores();
                    } else if (usuario.getTipo().equalsIgnoreCase("Aluno")) {
                        Aluno novo_aluno = new Aluno(usuario.getNome(), usuario.getMatricula(), usuario.getTipo(), usuario.getCpf(), usuario.getEmail());
                        aluno.cadastrarUsuario(novo_aluno);
                        System.out.println("Aluno Cadastrado com sucesso!");
                        aluno.listarAlunos();
                    } else {
                        System.out.println("Tipo inserido invalido!");
                        System.out.println("Digite somente Aluno ou Professor");
                    }
                    break;
                case 3:
                    System.out.println("=================");
                    System.out.println("DISPONIBILIDADE DE LIVROS");
                    System.out.println("=================");

                    biblioteca.listarLivrosDisponiveis();
                    biblioteca.listarLivrosEmprestados();

                    break;
                case 4:
                    //✅ Empréstimos: número do empréstimo, usuário, livro(s), data e status do empréstimo.
                    System.out.println("---------------------------");
                    System.out.println("EMPRESTIMO DE LIVROS");
                    System.out.println("---------------------------");
                    System.out.println("Digite '1' se for Aluno e '2' se for Professor");
                    int tipagem = sc.nextInt();
                    sc.nextLine();

                    Usuario usuario_encontrado = null; // Inicializando a variável
                    Cadastrado cadastrado = new Cadastrado();

                    if (tipagem == 1) {
                        System.out.println("Digite o número da matrícula do Aluno: ");
                        String matricula_usuario = sc.nextLine();
                        usuario_encontrado = aluno.buscarAlunoPorMatricula(matricula_usuario);

                        if (usuario_encontrado == null) {
                            System.out.println("Usuário não encontrado!");
                            return; // Sai do fluxo caso o usuário não seja encontrado
                        }
                    } else if (tipagem == 2) {
                        System.out.println("Digite o número da matrícula do Professor: ");
                        String matricula_usuario = sc.nextLine();
                        usuario_encontrado = professor.buscarProfessorPorMatricula(matricula_usuario);
                        //Não ta funcionando
                        if (usuario_encontrado == null) {
                            System.out.println("Usuário não encontrado!");
                            return;
                        }
                    } else {
                        System.out.println("Opção inválida! Digite apenas 1 para Aluno ou 2 para Professor.");
                        return;
                    }

                    System.out.println("Digite o nome do Livro: ");
                    String titulo_livro = sc.nextLine();
                    Livro biblioteca1 = biblioteca.buscarLivroPorTitulo(titulo_livro);
                    biblioteca1.setDisponivel(false);

                    if (biblioteca1 == null) {
                        System.out.println("Livro não encontrado!");
                        return;
                    }

                    Cadastrado novoCadastro = new Cadastrado(biblioteca1, usuario_encontrado);
                    biblioteca.registrarEmprestimo(novoCadastro);

                    System.out.println("Empréstimo realizado com sucesso!");
                    biblioteca.listarEmprestimos();
                    break;
                case 5:
                    System.out.println("---------------------------");
                    System.out.println("DEVOLUÇÃO DE LIVROS");
                    System.out.println("---------------------------");

                    System.out.println("Lista de emprestimos:");
                    biblioteca.listarEmprestimos(); // Mostra quem pegou qual livro

                    System.out.println("Digite o nome do livro que deseja devolver:");
                    String tituloDevolucao = sc.nextLine();
                    biblioteca.realizarDevolucao(tituloDevolucao);
                    break;

            }

        } while (resposta != 0);

        System.out.println(" Seção encerrada...");
    }
}