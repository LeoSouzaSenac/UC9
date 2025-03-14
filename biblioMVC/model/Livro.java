/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC.model;

/**
 *
 * @author Aluno
 */
public class Livro {
    
    // Atributos privados que armazenam as informações do livro
    private int id;          // O ID do livro (geralmente gerado automaticamente pelo banco)
    private String titulo;   // O título do livro
    private String autor;    // O autor do livro
    private int ano;         // O ano de publicação do livro
    

   
      // Construtor que inicializa um objeto Livro com título, autor e ano
    
    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    // Método para acessar o ID do livro
    public int getId() {
        return id;
    }

    // Método para definir o ID do livro
    public void setId(int id) {
        this.id = id;
    }

    // Método para acessar o título do livro
    public String getTitulo() {
        return titulo;
    }

    // Método para definir o título do livro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Método para acessar o autor do livro
    public String getAutor() {
        return autor;
    }

    // Método para definir o autor do livro
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Método para acessar o ano de publicação do livro
    public int getAno() {
        return ano;
    }

    // Método para definir o ano de publicação do livro
    public void setAno(int ano) {this.ano = ano;}
}


/*
A classe Livro é uma representação de um livro, com os atributos necessários 
para armazenar informações sobre um livro, como o id, titulo, autor, e ano. 
Essa classe é fundamental para o gerenciamento dos dados dos livros em 
qualquer aplicação que precise trabalhar com informações bibliográficas.

*/
