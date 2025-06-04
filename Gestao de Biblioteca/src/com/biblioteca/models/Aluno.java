package com.biblioteca.models;

import java.util.ArrayList;
import java.util.List;
//Aluno receber atributos de usuario
public class Aluno extends Usuario {
    List<Aluno> alunos = new ArrayList<>();

    public Aluno(Usuario usuario) {

    }

    public Aluno(String nome, String matricula, String tipo, String cpf, String email) {
        super(nome, matricula, tipo, cpf, email);
    }

    public Aluno() {

    }

    public void cadastrarUsuario(Aluno aluno) {
        alunos.add(aluno);
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno(a) cadastrado");
        } else {
            for (Usuario usuario : alunos) {
                System.out.println(usuario);
            }
        }
    }

    public Aluno buscarAlunoPorMatricula(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() != null && aluno.getMatricula().equalsIgnoreCase(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Aluno" + getNome() + "|" + "Matricula: " + getMatricula() + "|" + "Cpf: " + getCpf() + "|" + "Email " + getEmail();
    }

}
