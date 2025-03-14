/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioMVC.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class CriarTabela {
    public static void criarTabelaLivros(Connection conexao) {
        String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "titulo TEXT NOT NULL," +
                     "autor TEXT NOT NULL," +
                     "ano INTEGER NOT NULL" +
                     ");";

        try (Statement stmt = conexao.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'livros' verificada/criada com sucesso.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar a tabela: " + e.getMessage());
        }
    }

    
}
