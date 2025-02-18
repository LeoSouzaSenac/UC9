# 📌 O que são Modelos (Model) no Padrão MVC?

## ✅ Introdução
Quando criamos um programa, precisamos armazenar e manipular informações. No padrão **MVC (Model-View-Controller)**, a parte responsável por lidar com os dados é chamada de **Model**.

Imagine que estamos criando um **gerenciador de biblioteca**. Precisamos armazenar informações sobre os **livros** (título, autor, ano de publicação, etc.). No código, essa informação precisa estar organizada de forma clara e acessível. É aí que entra o **Model**!

---

## 📖 O que é um Model?
O **Model** é a parte do código que representa os **dados** e as **regras de negócio** do sistema.

- Ele define quais informações o sistema precisa armazenar.
- Ele interage com o banco de dados para **salvar, buscar, atualizar e excluir** informações.
- Ele protege os dados, garantindo que sejam usados corretamente.

🔹 Em resumo: o **Model é a "memória" do sistema**. Ele cuida dos dados e das regras que fazem o sistema funcionar corretamente.

---

## 🎯 Exemplo Prático: Criando um Model para Livros
Se estamos desenvolvendo um **gerenciador de biblioteca**, precisamos armazenar informações sobre os livros.

Vamos criar um **Model** chamado `Livro` no Java para representar um livro na nossa aplicação:

```java
package model; // Pacote onde a classe ficará

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    // Construtor
    public Livro(int id, String titulo, String autor, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // Métodos Getters e Setters para acessar os atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
```

📌 **Explicação do código:**
- Criamos uma classe chamada `Livro`.
- Definimos **atributos** (`id`, `titulo`, `autor`, `anoPublicacao`) para armazenar as informações do livro.
- Criamos um **construtor**, que serve para criar objetos `Livro` com valores definidos.
- Criamos **métodos Getters e Setters** para acessar e modificar os valores dos atributos com segurança.

---

## 🔗 Model e Banco de Dados
Para salvar os livros no banco de dados, usamos **JDBC (Java Database Connectivity)**.

Aqui está um exemplo de como o Model pode se conectar ao banco de dados para salvar um livro:

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {
    private Connection conexao;

    public LivroDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO livros (titulo, autor, anoPublicacao) VALUES (?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, livro.getTitulo());
        stmt.setString(2, livro.getAutor());
        stmt.setInt(3, livro.getAnoPublicacao());
        stmt.executeUpdate();
        stmt.close();
    }
}
```

📌 **Explicação:**
- Criamos a classe `LivroDAO`, responsável por salvar os dados no banco de dados.
- Criamos o método `adicionarLivro()` que insere um novo livro na tabela `livros` do banco de dados.
- Usamos **PreparedStatement** para evitar falhas de segurança (SQL Injection).

---

## 💡 Conclusão
- O **Model** é a parte do sistema que gerencia os **dados** e a **lógica de negócio**.
- Ele representa objetos do mundo real dentro do código (exemplo: um livro).
- Ele se conecta ao banco de dados para armazenar e recuperar informações.
- Sem um **Model**, o sistema não saberia como armazenar ou processar dados corretamente!

No próximo passo, vamos criar a **View (Interface Gráfica)** para exibir essas informações na tela! 🚀

