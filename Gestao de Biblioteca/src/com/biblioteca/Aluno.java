package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario{
    List<Aluno> alunos = new ArrayList<>();

   public Aluno(Usuario usuario) {

   }

   public Aluno (String nome, String matricula,String tipo, String cpf, String email){
       super(nome, matricula, tipo, cpf, email);
   }

   public Aluno(){

   }

    public void cadastrarUsuario(Aluno aluno) {
       alunos.add(aluno);
    }

   public void listarAlunos() {
       for (Usuario usuario : alunos) {
           System.out.println(alunos);
       }
   }

   public Aluno buscarAlunoPorMatricula(String matricula) {
       for (Aluno aluno : alunos){
           if (aluno.getMatricula() != null && aluno.getMatricula().equalsIgnoreCase(matricula)){
               return aluno;
           }
       }
       return null;
   }

    public String toString(){
        return "Aluno" + getNome() + "|" + "Matricula: " + getMatricula() + "|" + "Cpf: " + getCpf() + "|" + "Email " + getEmail()  ;
    }

}
