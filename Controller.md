# 📌 A Camada Controller no Padrão MVC

## ✅ Introdução
A **Camada Controller** é responsável por controlar o fluxo de dados entre a **View (Interface Gráfica)** e o **Model (Regras de Negócio e Banco de Dados)**. No nosso projeto, o Controller será responsável por capturar os dados da interface gráfica e enviá-los para serem salvos no banco de dados via JDBC.

No padrão MVC:
- A **View** exibe a interface e recebe a interação do usuário.
- O **Model** representa os dados e realiza a comunicação com o banco.
- O **Controller** gerencia a lógica da aplicação e faz a ponte entre Model e View.

---

## 🎯 Criando a Classe Controller
Vamos criar a classe `LivroController`, que será responsável por gerenciar as ações relacionadas aos livros no nosso sistema.

### 🚀 Passos para Criar o Controller:
1. No **NetBeans**, vá até o **pacote controller**.
2. Clique com o botão direito em **controller > New > Java Class**.
3. Nomeie a classe como `LivroController` e clique em **Finish**.

Agora, vamos implementar os métodos principais dentro do `LivroController`.

---

## 🔹 Implementando os Métodos do Controller

### 📝 Método para Salvar um Livro
Esse método recebe um objeto `Livro` e chama o Model para armazená-lo no banco de dados.

```java
import java.sql.SQLException;
import model.Livro;
import model.LivroDAO;

public class LivroController {
    
    public void salvarLivro(Livro livro) {
        LivroDAO livroDAO = new LivroDAO();
        try {
            livroDAO.inserir(livro);
            System.out.println("Livro salvo com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar livro: " + e.getMessage());
        }
    }
}
```

📌 **Explicação:**
- Criamos um objeto `LivroDAO`, que é responsável pela conexão com o banco.
- Chamamos o método `inserir(livro)` para armazenar o livro.
- Se ocorrer um erro, ele será capturado e exibido no console.

---

### 📖 Método para Buscar Todos os Livros
Esse método retorna uma lista de todos os livros cadastrados no banco de dados.

```java
import java.sql.SQLException;
import java.util.List;
import model.Livro;
import model.LivroDAO;

public class LivroController {
    
    // Método para buscar todos os livros
    public List<Livro> buscarTodosLivros() {
        LivroDAO livroDAO = new LivroDAO();
        try {
            return livroDAO.listarTodos();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar livros: " + e.getMessage());
            return null;
        }
    }
}
```

📌 **Explicação:**
- Criamos um objeto `LivroDAO`.
- Chamamos o método `listarTodos()` para buscar os livros do banco.
- Se ocorrer um erro, ele será capturado e uma mensagem será exibida no console.

---

### ✏ Método para Atualizar um Livro
Esse método recebe um livro já existente e atualiza seus dados no banco.

```java
public void atualizarLivro(Livro livro) {
    LivroDAO livroDAO = new LivroDAO();
    try {
        livroDAO.atualizar(livro);
        System.out.println("Livro atualizado com sucesso!");
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar livro: " + e.getMessage());
    }
}
```

📌 **Explicação:**
- Criamos um objeto `LivroDAO`.
- Chamamos `atualizar(livro)` para modificar os dados do livro no banco.
- Exibimos uma mensagem de sucesso ou erro no console.

---

### ❌ Método para Excluir um Livro
Esse método recebe um ID de livro e o remove do banco.

```java
public void excluirLivro(int id) {
    LivroDAO livroDAO = new LivroDAO();
    try {
        livroDAO.excluir(id);
        System.out.println("Livro excluído com sucesso!");
    } catch (SQLException e) {
        System.out.println("Erro ao excluir livro: " + e.getMessage());
    }
}
```

📌 **Explicação:**
- Criamos um objeto `LivroDAO`.
- Chamamos `excluir(id)`, que remove o livro do banco pelo ID.
- Exibimos uma mensagem indicando se a operação foi bem-sucedida.

---

## 🔄 Conectando a View ao Controller
Agora, na tela gráfica (`TelaCadastroLivro`), chamamos os métodos do `LivroController` para realizar operações no banco de dados.

### 📝 Salvando um Livro a partir da View
No **evento do botão Salvar**, adicionamos o seguinte código:

```java
private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {  
    String titulo = txtTitulo.getText();
    String autor = txtAutor.getText();
    int ano = (int) spinnerAno.getValue();
    
    Livro livro = new Livro(0, titulo, autor, ano);
    LivroController controller = new LivroController();
    controller.salvarLivro(livro);
    
    JOptionPane.showMessageDialog(this, "Livro salvo com sucesso!");
}
```

📌 **Explicação:**
- Pegamos os valores dos campos de texto e criamos um objeto `Livro`.
- Chamamos `controller.salvarLivro(livro)` para armazenar os dados no banco.
- Exibimos uma mensagem de sucesso para o usuário.

### 🔄 Atualizando a Tabela na View
Após cada alteração (salvar, excluir, editar), precisamos **recarregar os dados na tabela**:

```java
private void carregarLivrosNaTabela() {
    DefaultTableModel modelo = (DefaultTableModel) tabelaLivros.getModel();
    modelo.setRowCount(0);
    
    LivroController controller = new LivroController();
    List<Livro> livros = controller.buscarTodosLivros();
    
    for (Livro livro : livros) {
        modelo.addRow(new Object[]{livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao()});
    }
}
```

📌 **Explicação:**
- **Limpa** a tabela antes de carregar os novos dados.
- **Busca todos os livros** cadastrados no banco.
- **Adiciona cada livro** à tabela, linha por linha.

🔹 **Chamamos esse método sempre que salvarmos um livro:**

```java
private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
    // Código para salvar...
    carregarLivrosNaTabela();
}
```

---

## 🔥 Conclusão
- O **Controller** faz a ligação entre a interface gráfica (View) e o banco de dados (Model).
- Criamos um **LivroController** para organizar os métodos de salvar, buscar, atualizar e excluir.
- Chamamos esses métodos a partir da interface gráfica sempre que o usuário realizar uma ação.
- Garantimos que a tabela seja atualizada automaticamente após cada operação.

Agora, nosso projeto já pode cadastrar, visualizar, editar e excluir livros! 🚀

