package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario{
    List<Usuario> alunos = new ArrayList<>();

   public Aluno(Usuario usuario) {

   }


    public void cadastrarUsuario(Usuario usuario) {
       alunos.add(usuario);
    }

}
