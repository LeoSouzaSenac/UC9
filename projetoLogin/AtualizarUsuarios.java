/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Aluno
 */
public class AtualizarUsuarios {
   public static void atualizarUsuarios(Connection conexao, int id, String novoNome, String novaSenha) {
        
        // A string SQL que vai realizar a atualização. 
        // A cláusula WHERE é usada para especificar qual usuário será atualizado com base no ID.
        String sql = "UPDATE usuarios SET nome = ?, senha = ? WHERE id = ?";

        try {
            // Cria um PreparedStatement para executar o SQL com parâmetros.
            // O PreparedStatement ajuda a prevenir ataques de SQL Injection, 
            //já que os valores dos parâmetros são definidos separadamente.
            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                
                // Substitui o primeiro parâmetro (?) com o novo nome fornecido.
                pstmt.setString(1, novoNome);
                
                // Substitui o segundo parâmetro (?) com o novo email fornecido.
                pstmt.setString(2, novaSenha);
                
                // Substitui o terceiro parâmetro (?) com o ID do usuário para identificar qual usuário atualizar.
                pstmt.setInt(3, id);
                
                // Executa o comando SQL e retorna o número de linhas afetadas pela operação.
                int rowsUpdated = pstmt.executeUpdate();

                // Verifica se pelo menos uma linha foi atualizada.
                if (rowsUpdated > 0) {
                    // Se a atualização foi bem-sucedida, imprime a mensagem de sucesso.
                    System.out.println("Usuário atualizado com sucesso!");
                } else {
                    // Se nenhuma linha foi atualizada (significa que o ID fornecido não foi encontrado), imprime uma mensagem.
                    System.out.println("Nenhum usuário encontrado com o ID fornecido.");
                }
            } catch (Exception e) {
                // Caso ocorra algum erro durante a execução do PreparedStatement, 
                // ele é capturado aqui.
                // O erro é impresso com uma mensagem explicativa.
                System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            }
        } catch (Exception e) {
            // Caso ocorra um erro ao tentar preparar ou executar a instrução SQL, 
            // ele é capturado aqui. A mensagem do erro é impressa.
            System.out.println("Erro ao conectar ou executar SQL: " + e.getMessage());
        }
    }
}
