package com.biblioteca;

import java.util.List;

public class Professor extends Usuario {
    List<Usuario> professor;



    public Professor(Usuario usuario) {

    }

    public void cadastrarUsuario(Usuario usuario) {
        professor.add(usuario);
    }
}
