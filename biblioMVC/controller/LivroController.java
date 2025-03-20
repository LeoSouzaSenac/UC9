/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC.controller;


import biblioMVC.model.Livro;
import biblioMVC.model.LivroDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */

/**
 * Classe LivroController que atua como controlador na arquitetura MVC (Model-View-Controller).
 * Ela faz a intermediação entre a camada de visão (View) e a camada de modelo (Model),
 * permitindo a manipulação dos dados de livros.
 */
public class LivroController {
    
    // Atributo privado que faz a interação com o banco de dados (via LivroDAO)
    private LivroDAO livroDAO;

    // Construtor da classe, que inicializa o objeto LivroDAO
    public LivroController() {
        this.livroDAO = new LivroDAO();  // Cria uma instância de LivroDAO para acessar o banco de dados
    }

    // Método para adicionar um livro no banco de dados
    public String adicionarLivro(String titulo, String autor, String anoTexto)  {
        try {
            int ano = Integer.parseInt(anoTexto);
            Livro livro = new Livro(titulo, autor, ano);
            livroDAO.adicionarLivro(livro);
            return "Livro adicionado com sucesso!";
        } catch (NumberFormatException e) {
            return "Erro: " + e.getMessage();
        }
    }
   // Método que recebe os dados de LivroDAO e os formata para enviarmos para a view 
   public ArrayList<String> listarLivros() {
       
       // Crio um arrayList de strings para receber os dados tratados
        ArrayList<String> listaFormatada = new ArrayList<>();
        try {
            // o ArrayList livros recebe os dados de livroDAO, ainda sem tratamento
            ArrayList<Livro> livros = livroDAO.listarLivros();
            
            // Processando os dados antes de enviar para a View
            for (Livro livro : livros) {
                String detalhes = "ID: " + livro.getId() + " | " +
                                  "Título: " + livro.getTitulo() + " | " +
                                  "Autor: " + livro.getAutor() + " | " +
                                  "Ano: " + livro.getAno();
                listaFormatada.add(detalhes);
            }
        } catch (Exception e) {
            listaFormatada.add("Erro ao recuperar os livros: " + e.getMessage());
        }
        return listaFormatada;
    }
   
   public String deletarLivro(int index) {
    try {
        ArrayList<Livro> livros = livroDAO.listarLivros();

        // Verifica se o índice selecionado é válido
        if (index >= 0 && index < livros.size()) {
            int idLivro = livros.get(index).getId(); // Obtém o ID do livro correspondente ao índice
            livroDAO.deletarLivro(idLivro); // Deleta o livro pelo ID
            return "Livro deletado com sucesso!";
        } else {
            return "Erro: Índice inválido!";
        }
    } catch (Exception e) {
        return "Erro ao deletar livro: " + e.getMessage();
    }
}
   
  


}

/*
A classe LivroController é um controlador na arquitetura MVC (Model-View-Controller). 
Seu papel é atuar como intermediário entre a visão (View) e o modelo (Model), 
permitindo que a interface do usuário interaja com os dados de forma organizada. 
No caso, ela lida com operações relacionadas a livros e interage com a camada de persistência, 
que é a classe LivroDAO.

*/
