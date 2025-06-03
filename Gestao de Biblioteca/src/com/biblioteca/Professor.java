package com.biblioteca;

import java.util.ArrayList;
import java.util.List;
//Classe professor que recebe os atributos de usuario
public class Professor extends Usuario {
    List<Professor> professores = new ArrayList<>();

//Construtor vazio
    public Professor() {

    }


    public Professor(String nome, String matricula, String tipo, String cpf, String email) {
        super(nome, matricula, tipo, cpf, email); // Chama o construtor da classe pai (Usuario)
    }

    public void cadastrarUsuario(Professor professor) {
        professores.add(professor);
    }

    public Professor busscarProfessor(ArrayList<Professor> professores, String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equals(nome)) {
                return professor;
            }
        }
        return null;
    }

    public void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor(a) cadastrado");
        } else {
            for (Usuario usuario : professores) {
                System.out.println(usuario);
            }
        }
    }

    public Professor buscarProfessorPorMatricula(String matricula) {
        for (Professor professor : professores) {
            if (professor.getMatricula().equalsIgnoreCase(matricula)) {
                return professor;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Professor" + getNome() + "|" + "Matricula: " + getMatricula() + "|" + "Cpf: " + getCpf() + "|" + "Email " + getEmail();
    }
}
