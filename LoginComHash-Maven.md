Primeiro de tudo, crie um projeto chamado "loginComHash" no NetBeans.
Depois, crie a estrutura de projeto de acordo com a imagem:
<img width="155" alt="Captura de tela 2025-04-11 180233" src="https://github.com/user-attachments/assets/7fe58ece-94b5-4b2c-87fe-e46f708981b4" />


# ⚙️ Configurando as Dependências no `build.gradle`

Para que seu projeto funcione corretamente com banco de dados, variáveis de ambiente e segurança de senhas, você precisa adicionar **algumas bibliotecas (dependências)** no seu `build.gradle`.

---

## 📌 Onde colocar?

Abra o arquivo `pom.xml` (geralmente fica na raiz do projeto) e adicione as linhas abaixo dentro do bloco `dependencies { }`:

```groovy
<dependencies>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>

    <dependency>
        <groupId>org.mindrot</groupId>
        <artifactId>jbcrypt</artifactId>
        <version>0.4</version>
    </dependency>

    <dependency>
        <groupId>io.github.cdimascio</groupId>
        <artifactId>dotenv-java</artifactId>
        <version>2.2.4</version>
    </dependency>
</dependencies>

```

Depois de salvar, o Maven vai baixar automaticamente essas bibliotecas.

---

## 📦 O que cada uma faz?

### 1. 🐬 `mysql-connector-java`

```groovy
implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.33'
```

Essa é a **biblioteca oficial do MySQL**. Ela permite que o Java se conecte ao banco de dados MySQL e execute comandos (SELECT, INSERT, etc).

---

### 2. 🔒 `jbcrypt`

```groovy
implementation group: 'org.mindrot', name: 'jbcrypt', version: '0.4'
```

Essa biblioteca permite **criptografar senhas com segurança**. É usada para proteger as senhas dos usuários antes de salvar no banco.

> Em vez de salvar a senha como "1234", você salva como um código embaralhado.

---

### 3. 🌿 `dotenv-java`

```groovy
implementation 'io.github.cdimascio:dotenv-java:2.2.4'
```

Permite que você **leia variáveis de ambiente** de um arquivo `.env`, como:

```
DB_URL=jdbc:mysql://localhost:3306/meubanco
DB_USER=root
DB_PASSWORD=1234
```

Assim, você **não precisa colocar usuário e senha do banco diretamente no código** — o que é mais seguro e organizado.

---

## ✅ Depois de adicionar as dependências...

1. Salve o arquivo `build.gradle`
2. No NetBeans, na pasta raiz do projeto, clique em **"Clean and Build**


## 🧠 Por que usar bibliotecas?

Porque elas **facilitam sua vida**, evitando que você reescreva códigos complicados que já existem, funcionam bem e são mantidos por outras pessoas.



#  Como Criar um Arquivo `.env` no NetBeans e Para Que Ele Serve

---

## 📘 O que é um `.env`?

O arquivo `.env` é um arquivo de **configuração** que serve para guardar **informações importantes e secretas** do seu projeto, como:

- URL do banco de dados
- Usuário e senha do banco
- Chaves de API, tokens, etc.

> Ele ajuda a deixar o seu código **mais seguro** e **organizado**, separando os dados sensíveis do código-fonte.

---

## 📁 Exemplo de `.env`

```env
DB_URL=jdbc:mysql://localhost:3306/projetoMVC
DB_USER=root
DB_PASSWORD=root
```

Essas variáveis serão usadas no seu código Java usando a biblioteca `dotenv-java`.

---

## 🛠️ Como criar um `.env` no NetBeans

1. **Clique com o botão direito no seu projeto**
2. Vá em **Novo > Outro...**
3. Escolha **Arquivo de texto vazio** (ou "Other > Empty File")
4. Dê o nome:  
   ```
   .env
   ```
   (sim, com o ponto na frente!)
5. Clique em **Finalizar**


---

## 🧪 Como o `.env` é usado no Java?

No seu código Java, você carrega esse arquivo assim:

```java
Dotenv dotenv = Dotenv.load();
String url = dotenv.get("DB_URL");
String user = dotenv.get("DB_USER");
String password = dotenv.get("DB_PASSWORD");
```

Assim, você pode conectar no banco de dados **sem precisar colocar esses dados direto no código**, deixando tudo mais seguro e profissional ✅

---

## 🧠 Vantagens de usar o `.env`

| Vantagem                        | Explicação |
|-------------------------------|------------|
| 🔒 Segurança                  | Você não expõe senhas no código |
| 🔄 Facilidade de mudança       | Basta editar o `.env`, sem mexer no Java |
| 📁 Organização                 | Separa dados de configuração do código |
| 🌎 Portabilidade               | Outros desenvolvedores podem usar seus próprios dados |




# 📦 Criando a Classe `Conexao` na Camada `database`

## 📁 Onde criar essa classe?

Crie dentro do pacote `loginComHash.database`, que representa a **camada de acesso ao banco de dados**:

```
src/
└── loginComHash/
    └── database/
        └── Conexao.java
```

---

## 🧱 O que essa classe faz?

A classe `Conexao` tem como objetivo:

- Ler informações de conexão com o banco de dados a partir de um arquivo `.env`
- Criar uma conexão com o MySQL
- Garantir que a tabela `usuarios` exista no banco
- Reutilizar a mesma conexão durante o programa

---

## 🧪 Etapas e Explicações

### 🔹 1. Importações Necessárias

```java
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
```

> Essas importações são necessárias para:
- Acessar variáveis do arquivo `.env`
- Estabelecer conexão com o banco
- Executar comandos SQL
- Tratar erros do banco

---

### 🔹 2. Carregar Variáveis do `.env`

```java
private static final Dotenv dotenv = Dotenv.load();
```

> Lê automaticamente as variáveis definidas no arquivo `.env`, como `DB_URL`, `DB_USER` e `DB_PASSWORD`.

---

### 🔹 3. Criar Constantes para Conexão

```java
private static final String URL = dotenv.get("DB_URL");
private static final String DB_USER = dotenv.get("DB_USER");
private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");
```

> Guardam as configurações de conexão como constantes para serem usadas no programa.

---

### 🔹 4. Variável de Conexão

```java
private static Connection connection;
```

> Guarda a conexão com o banco para que ela seja usada sempre que o sistema precisar.

---

### 🔹 5. Método `conectar()`

```java
public static Connection conectar() {
    ...
}
```

> Responsável por verificar se já existe uma conexão ou se é necessário criar uma nova.

---

### 🔹 6. Método `criarTabela()`

```java
private static void criarTabela() {
    ...
}
```

> Cria a tabela `usuarios` se ela ainda não existir no banco.

---

## 🧩 Como Usar

Basta chamar:

```java
Connection conn = Conexao.conectar();
```

Isso já garante que:

✅ A conexão foi criada (ou reutilizada)  
✅ A tabela `usuarios` existe  

---

## ✅ Classe Completa `Conexao.java`

```java
package loginComHash.database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    // Carrega as variáveis do arquivo .env
    private static final Dotenv dotenv = Dotenv.load();

    private static Connection connection;

    // Variáveis de conexão
    private static final String URL = dotenv.get("DB_URL");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    // Conecta ao banco de dados
    public static Connection conectar() {
        try {
            // Se ainda não houver conexão, cria uma nova
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
                criarTabela();
                System.out.println("Conectado ao banco.");
            }
        } catch (SQLException error) {
            throw new RuntimeException("Erro na conexão com o banco de dados", error);
        }

        return connection;
    }

    // Cria a tabela de usuários se ela não existir
    private static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "usuario VARCHAR(255) NOT NULL UNIQUE, "
                + "senha VARCHAR(255) NOT NULL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela", e);
        }
    }
}
```


# 🧍 Criando a Classe `Usuario` na Camada `model`

## 📁 Onde criar essa classe?

Crie dentro do pacote `loginComHash.model`, que representa a **camada de modelo**:

```
src/
└── loginComHash/
    └── model/
        └── Usuario.java
```

---

## 📄 Para que serve essa classe?

A classe `Usuario` representa os **dados de um usuário** do sistema. Ela é um **modelo** (ou "entidade") que ajuda a organizar as informações que vêm do banco ou que serão inseridas.

---

## 🧱 Estrutura da Classe `Usuario`

### 🔹 Atributos

```java
private int id;
private String email;
private String senha;
```

- `id`: identificador único do usuário no banco de dados.
- `email`: será usado como o "nome de usuário" para login.
- `senha`: armazena a senha (que será protegida com hash).

---

### 🔹 Construtor

```java
public Usuario(String email, String senha) {
    this.email = email;
    this.senha = senha;
}
```

> Um **construtor** é chamado quando criamos um novo objeto. Aqui, ao criar um usuário novo, passamos o `email` e a `senha`.

---

### 🔹 Métodos `get` e `set`

Chamados de **getters e setters**, eles servem para:

- Ler valores (`get`)
- Alterar valores (`set`)

Exemplo:

```java
usuario.getEmail();     // Lê o email
usuario.setSenha("...") // Altera a senha
```

> Isso ajuda a proteger os dados (boa prática de programação orientada a objetos).

---

## 🧩 Como Usar

```java
Usuario novoUsuario = new Usuario("exemplo@email.com", "senha123");
System.out.println(novoUsuario.getEmail());
```

---

## ✅ Classe Completa `Usuario.java`

```java
package loginComHash.model;

public class Usuario {
    private int id;
    private String email;
    private String senha;

    // Construtor
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    // Get e Set do ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Get e Set do Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Get e Set da Senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
```



# 🧍 Criando a Classe `UsuarioDAO` na Camada `dao`

## 📁 Onde criar essa classe?

Crie dentro do pacote `loginComHash.dao`, que representa a **camada de Data Access Object**:

```
src/
└── loginComHash/
    └── dao/
        └── UsuarioDAO.java
```

A classe `UsuarioDAO` é responsável por fazer a comunicação entre o sistema e o banco de dados, **executando ações como:**
- cadastrar um novo usuário com senha criptografada;
- verificar se o login é válido;
- atualizar senha;
- excluir um usuário;
- listar todos os usuários cadastrados.

---

## 1️⃣ **Criar a classe e o pacote**

Primeiro, dentro do seu projeto, crie o pacote `dao` e dentro dele, crie a classe `UsuarioDAO`.

```java
package loginComHash.dao;

public class UsuarioDAO {
    // Aqui vão os métodos que acessam o banco de dados
}
```

---

## 2️⃣ **Importar as bibliotecas necessárias**

Vamos importar o que será usado:

```java
import loginComHash.database.Conexao;
import loginComHash.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
```

### Explicação:
- `Conexao`: Classe que conecta ao banco.
- `Usuario`: Classe com `email` e `senha`.
- `BCrypt`: Criptografa senhas com segurança.
- `java.sql.*`: Permite conectar ao banco e fazer comandos SQL.
- `ArrayList/List`: Para armazenar e retornar listas de usuários.

---

## 3️⃣ **Método: registrar um novo usuário**

Vamos fazer um método que **recebe um objeto `Usuario` e salva no banco**, com a senha criptografada:

```java
public boolean registrarUsuario(Usuario usuario) {
    String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
    String senhaHash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());

    try (Connection conn = Conexao.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, usuario.getEmail());
        stmt.setString(2, senhaHash);
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
```

### 🔍 Explicação:
- Cria uma `String sql` com o comando `INSERT`.
- `BCrypt.hashpw(...)`: Cria o hash da senha.
- `PreparedStatement`: Envia os dados com segurança.
- `stmt.executeUpdate()`: Executa o comando no banco.
- `try-with-resources`: Fecha a conexão automaticamente.

---

## 4️⃣ **Método: validar login**

Este método confere se a senha informada é igual à senha salva (em forma de hash) no banco:

```java
public boolean validarLogin(Usuario usuario) {
    String sql = "SELECT senha FROM usuarios WHERE usuario = ?";

    try (Connection conn = Conexao.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, usuario.getEmail());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String senhaHash = rs.getString("senha");
            return BCrypt.checkpw(usuario.getSenha(), senhaHash);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
```

### 🔍 Explicação:
- Busca o `hash da senha` no banco.
- `BCrypt.checkpw(...)`: Compara a senha digitada com o hash.
- Retorna `true` se for válida.

---

## 5️⃣ **Método: buscar usuário pelo email**

Serve para retornar o usuário (objeto `Usuario`) com os dados do banco:

```java
public Usuario buscarUsuarioPorEmail(String email) {
    String sql = "SELECT * FROM usuarios WHERE usuario = ?";

    try (Connection conn = Conexao.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Usuario usuario = new Usuario(rs.getString("usuario"), rs.getString("senha"));
            return usuario;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
```

---

## 6️⃣ **Método: atualizar a senha**

Permite atualizar a senha de um usuário (com hash novo):

```java
public boolean atualizarSenha(String email, String novaSenha) {
    String sql = "UPDATE usuarios SET senha = ? WHERE usuario = ?";
    String senhaHash = BCrypt.hashpw(novaSenha, BCrypt.gensalt());

    try (Connection conn = Conexao.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, senhaHash);
        stmt.setString(2, email);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
```

---

## 7️⃣ **Método: excluir usuário**

Deleta um usuário do banco de dados pelo email:

```java
public boolean excluirUsuario(String email) {
    String sql = "DELETE FROM usuarios WHERE usuario = ?";

    try (Connection conn = Conexao.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, email);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
```

---

## 8️⃣ **Método: listar todos os usuários**

Retorna uma lista com todos os usuários cadastrados (sem senha):

```java
public List<Usuario> listarUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();
    String sql = "SELECT usuario FROM usuarios";

    try (Connection conn = Conexao.conectar(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Usuario usuario = new Usuario(rs.getString("usuario"), ""); // senha não exibida
            usuarios.add(usuario);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return usuarios;
}
```

---

## ✅ **Classe completa pronta**

```java
package loginComHash.dao;

import loginComHash.database.Conexao;
import loginComHash.model.Usuario;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";
        String senhaHash = BCrypt.hashpw(usuario.getSenha(), BCrypt.gensalt());

        try (Connection conn = Conexao.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, senhaHash);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validarLogin(Usuario usuario) {
        String sql = "SELECT senha FROM usuarios WHERE usuario = ?";

        try (Connection conn = Conexao.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getEmail());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaHash = rs.getString("senha");
                return BCrypt.checkpw(usuario.getSenha(), senhaHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ?";

        try (Connection conn = Conexao.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(rs.getString("usuario"), rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean atualizarSenha(String email, String novaSenha) {
        String sql = "UPDATE usuarios SET senha = ? WHERE usuario = ?";
        String senhaHash = BCrypt.hashpw(novaSenha, BCrypt.gensalt());

        try (Connection conn = Conexao.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, senhaHash);
            stmt.setString(2, email);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluirUsuario(String email) {
        String sql = "DELETE FROM usuarios WHERE usuario = ?";

        try (Connection conn = Conexao.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT usuario FROM usuarios";

        try (Connection conn = Conexao.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getString("usuario"), "");
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
```



