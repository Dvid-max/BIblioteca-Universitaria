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


}
