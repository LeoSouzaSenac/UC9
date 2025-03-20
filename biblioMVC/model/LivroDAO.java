/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC.model;

/**
 *
 * @author Aluno
 */
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

// Definição da classe LivroDAO (DAO = Data Access Object/ Objeto de acesso a dados), que é responsável pelas operações no banco de dados relacionadas aos livros
public class LivroDAO {
    
    // Atributo para armazenar a conexão com o banco de dados
    private Connection conexao;
  
    // Construtor da classe, responsável por estabelecer a conexão com o banco de dados
    public LivroDAO() {
        conexao = ConexaoSQLite.conectar();
    }

    // Método público para adicionar um novo livro ao banco de dados
    public void adicionarLivro(Livro livro) {
        // Comando SQL para inserir um novo livro na tabela 'livros'
        String sql = "INSERT INTO livros (titulo, autor, ano) VALUES (?, ?, ?)";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Definindo os parâmetros do comando SQL com os dados do livro
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            
            // Executa a atualização no banco de dados
            stmt.executeUpdate();
            
            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
        } catch (SQLException e) {
            // Se ocorrer um erro durante a inserção, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(null, "Erro ao adicionar livro: " + e.getMessage());
        }
    }

    // Método que faz um select de todos os livros no banco de dados e os adiciona em um arrayList
   public ArrayList<Livro> listarLivros() {
       // Crio um arrayList de Livros
        ArrayList<Livro> lista = new ArrayList<>();
        // Faço um select para retornar todos os livros do meu banco
        String sql = "SELECT * FROM livros";

        // Como é apenas um select, um comando simples, uso o Statement
        try (Statement stmt = conexao.createStatement();
             // Executo o comando e armazeno dentro de um ResultSet
             ResultSet rs = stmt.executeQuery(sql)) {
             
            // Este while percorre todos os resultados da minha consulta
            while (rs.next()) {
                Livro livro = new Livro(
                    rs.getString("titulo"), 
                    rs.getString("autor"), 
                    rs.getInt("ano")
                );
                // Como não passo o ID no construtor do livro, eu preciso chamar o método setID para passar o ID
                livro.setId(rs.getInt("id"));
                // Adiciono o livro no arrayList
                lista.add(livro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar livros: " + e.getMessage());
        }
        return lista;
    }
   
   // Método para deletar um livro pelo ID
public void deletarLivro(int id) {
    String sql = "DELETE FROM livros WHERE id = ?";

    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
        // Define o ID do livro a ser deletado
        stmt.setInt(1, id);
        
        // Executa a exclusão
        int rowsAffected = stmt.executeUpdate();

        // Verifica se o livro foi deletado com sucesso
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Livro deletado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum livro encontrado com esse ID.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao deletar livro: " + e.getMessage());
    }
}
   
  
}


/*
A classe LivroDAO é uma implementação da camada de Data Access Object (DAO), 
que gerencia a interação entre a aplicação e o banco de dados, nesse caso, 
para a manipulação de dados relacionados a livros.

*/
