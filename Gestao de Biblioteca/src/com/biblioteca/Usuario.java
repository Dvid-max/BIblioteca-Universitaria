package com.biblioteca;

public  class Usuario {
    //Criando atributos como String porque podem possuir caracteres especiais
    private String nome;
    private String matricula;
    private String tipo;
    private String cpf;
    private String email;




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Usuario(String nome, String matricula,String tipo,  String cpf, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.email = email;
    }
    public Usuario() {

    }



}
