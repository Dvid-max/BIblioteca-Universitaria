package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    List<Aluno> alunos = new ArrayList<>();

    public Aluno(Usuario usuario) {

    }

    public Aluno(String nome, String matricula, String tipo, String cpf, String email) {
        super(nome, matricula, tipo, cpf, email);
    }

    public Aluno() {

    }

    //Metodos
    public void cadastrarUsuario(Aluno aluno) {
        alunos.add(aluno);
    }

    public void listarAlunos() {
        int i = 0;
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno(a) encontrado");
        }
        for (Usuario usuario : alunos) {
            System.out.println((i + 1 ) + "." + usuario);
            i++;
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
    //Sobrescrevendo toString
    @Override
    public String toString() {
        return "Aluno: " + getNome() + "|" + "Matricula: " + getMatricula() + "|" + "Cpf: " + getCpf() + "|" + "Email " + getEmail();
    }

}
