package com.biblioteca;

//Classe cadastrado recebe um objeto livro e um objeto usuario
public class Cadastrado {
    private Livro livro;
    private Usuario usuario;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cadastrado(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
    }

    public Cadastrado() {
    }

    @Override
    public String toString() {
        return "Usuário: " + usuario.getNome() + " | Livro: " + livro.getTitulo();
    }


}
