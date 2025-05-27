package com.biblioteca;

import java.util.List;

public class Aluno extends Usuario{
    List<Usuario> alunos;

   public Aluno(Usuario usuario) {

   }


    public void cadastrarUsuario(Aluno aluno) {
        alunos.add(aluno);
    }

}
