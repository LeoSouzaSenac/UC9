/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Aluno
 */
public class BuscarUsuario {
    // Método para buscar o nome e senha de um usuário pelo nome
    public static String[] buscarUsuario(Connection conexao, String nomeUsuario) {
        // Array para armazenar nome e senha
        String[] dadosUsuario = new String[3];
        
        // SQL para selecionar o nome e a senha do usuário
        String sql = "SELECT * FROM usuarios WHERE nome = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            // Define o valor do parâmetro na consulta SQL
            stmt.setString(1, nomeUsuario);
            
            // Executa a consulta
            ResultSet rs = stmt.executeQuery();
            
            // Verifica se o usuário foi encontrado
            if (rs.next()) {
                // Armazena o nome e a senha do usuário
                dadosUsuario[0] = rs.getString("nome");
                dadosUsuario[1] = rs.getString("senha");
                dadosUsuario[2] = rs.getString("id");
            } else {
                // Caso o usuário não seja encontrado
                System.out.println("Usuário não encontrado.");
            }
        } catch (Exception e) {
            // Em caso de erro, exibe a mensagem de erro
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
        }
        
        // Retorna os dados do usuário (nome e senha)
        return dadosUsuario;
    }
}
