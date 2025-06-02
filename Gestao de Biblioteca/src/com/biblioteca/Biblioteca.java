package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
   List<Livro> livros = new ArrayList<>();
   List<Livro> emprestados = new ArrayList<>();

   public void cadastrarLivro(Livro livro) {
       livros.add(livro);
   }

   public  void listarLivros() {
       if (livros.isEmpty()) {
           System.out.println("Não há livros disponíveis");
       }
       int i = 0;
       for (Livro livro : livros) {
           System.out.println((i + 1 )+ " - "  + livro);
           i++;
       }
   }

   public void realizarEmprestimo(int i) {
      emprestados.add(livros.get(i));
      livros.remove(i);
   }

    public void realizarDevolucao(int i) {
        Livro devolvido = emprestados.get(i);
        livros.add(devolvido);
        emprestados.remove(i);
    }



    public void listarEmprestados() {
        int i = 0;
        for (Livro livro : emprestados) {
            System.out.println((i + 1) + " - " + livro); // Agora imprime só o livro da vez
            i++;
        }
    }


    public void mostrarEmprestados(int i) {
        String nome_livro = livros.get(i).getTitulo();
       System.out.println((i + 1 )+ " - "  + livros.get(i));
   }

   public String listarEmprestimos(String usuario_nome, String livro_titulo, String emprestimo_data ){
       return "usuario: " + usuario_nome + ". " + "livro: " + livro_titulo + ". " + "data: " + emprestimo_data;
   }
}
