package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    List<Professor> professores = new ArrayList<>();

   //Construtor vazio
    public Professor() {

    }

    //Criando metodos
    public Professor(String nome, String matricula, String tipo, String cpf, String email) {
        super(nome, matricula, tipo, cpf, email); // Chama o construtor da classe pai (Usuario)
    }

    public void cadastrarUsuario(Professor professor) {
        professores.add(professor);
    }

    public void listarProfessores() {
        if (professores.isEmpty()){
            System.out.println("Nenhum professor(a) encontrado");
        }
        int i = 0;
        for (Usuario usuario : professores) {
            System.out.println((i + 1) + "." + usuario);
            i++;
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
    // Sobrescrevendo função toString para exibir os dados necessarios
    @Override
    public String toString() {
        return "Professor: " + getNome() + "|" + "Matricula: " + getMatricula() + "|" + "Cpf: " + getCpf() + "|" + "Email " + getEmail();
    }
}
