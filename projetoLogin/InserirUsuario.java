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
public class InserirUsuario {
    // Método para inserir um usuário apenas se ele não existir no banco de dados
    public static boolean inserirUsuario(Connection conexao, String nome, String senha) {
        // Consulta SQL para verificar se o usuário já existe no banco de dados
        String sqlCheck = "SELECT * FROM usuarios WHERE nome = ?";
        // Comando SQL para inserir um novo usuário com nome e senha
        String sqlInsert = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";
        
        try (PreparedStatement checkStmt = conexao.prepareStatement(sqlCheck)) {
            // Define o valor do parâmetro na query SQL
            checkStmt.setString(1, nome);
            ResultSet rs = checkStmt.executeQuery();
            
            // Se existir um resultado, significa que o usuário já está cadastrado
            if (rs.next()) {
                System.out.println("Usuário já existe no banco de dados.");
                return false; // Encerra a execução do método sem inserir o usuário
            }
        
            try (PreparedStatement insertStmt = conexao.prepareStatement(sqlInsert)) {
                // Define os valores dos parâmetros na query SQL
                insertStmt.setString(1, nome);  // Substitui o primeiro ? pelo nome do usuário
                insertStmt.setString(2, senha); // Substitui o segundo ? pela senha do usuário
                
                // Executa a inserção no banco de dados
                insertStmt.executeUpdate();
                System.out.println("Usuário inserido com sucesso!");
                return true; // Usuário inserido com sucesso
            } 
        } catch (Exception e) {
            // Captura e exibe qualquer erro ocorrido durante a execução
            System.out.println("Erro ao inserir usuário: " + e.getMessage());  
        }
        return false;
    }
}
