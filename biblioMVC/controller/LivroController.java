/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC.controller;


import biblioMVC.model.Livro;
import biblioMVC.model.LivroDAO;
import java.sql.SQLException;
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
    


}

/*
A classe LivroController é um controlador na arquitetura MVC (Model-View-Controller). 
Seu papel é atuar como intermediário entre a visão (View) e o modelo (Model), 
permitindo que a interface do usuário interaja com os dados de forma organizada. 
No caso, ela lida com operações relacionadas a livros e interage com a camada de persistência, 
que é a classe LivroDAO.

*/
