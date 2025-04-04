/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package biblioMVC;

import biblioMVC.model.ConexaoSQLite;
import biblioMVC.model.CriarTabela;
import biblioMVC.view.FrmLivro;
import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        // Conectar ao banco de dados SQLite
        Connection conexao = ConexaoSQLite.conectar();

        // Criar a tabela de livros se não existir
        CriarTabela.criarTabelaLivros(conexao);

       
       
        new FrmLivro().setVisible(true);
        
    }
}
