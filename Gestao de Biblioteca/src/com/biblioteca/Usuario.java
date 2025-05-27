package com.biblioteca;

public  class Usuario {
    //Criando atributos como String porque podem possuir caracteres especiais
    private String nome;
    private String matricula;
    private String tipo;
    private String cpf;
    private String email;

    public Usuario(String nome, String matricula,String tipo,  String cpf, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.email = email;
    }
    public Usuario() {

    }

    public  void cadastrarUsuario() {
        System.out.println("usuario cadastrado");
    }

}
