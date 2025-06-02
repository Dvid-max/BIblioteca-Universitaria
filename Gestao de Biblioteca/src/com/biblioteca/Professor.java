package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    List<Usuario> professores;



    public Professor(Usuario usuario) {

    }

    public void cadastrarUsuario(Usuario usuario) {
        professores.add(usuario);
    }

    public Professor busscarProfessor(ArrayList<Professor> professores, String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equals(nome)) {
                return professor;
            }
        }
        return null;
    }
}
