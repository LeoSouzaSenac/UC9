# Introdução ao Padrão MVC e Criação do Projeto no NetBeans

## O que é o Padrão MVC?

O padrão MVC (Model-View-Controller) é uma forma organizada de estruturar um software dividindo-o em três partes principais:

- **Model (Modelo):** Responsável pelos dados.
- **View (Visão):** Responsável pela interface com o usuário.
- **Controller (Controlador):** Faz a ponte entre a View e o Model, gerenciando a interação do usuário com os dados.

Esse padrão é muito utilizado pois ajuda a manter o código organizado, facilita a manutenção e possibilita a reutilização de partes do sistema.

---

## Nosso Projeto: Gerenciador de Biblioteca

Vamos criar um sistema simples de Gerenciamento de Biblioteca onde os usuários poderão cadastrar, consultar, atualizar e excluir livros.

### Tecnologias Utilizadas:
- Java (Java with Gradle)
- NetBeans IDE 19
- JDBC para conexão com o banco de dados
- MySQL para armazenar os dados
- GUI Builder do NetBeans para criar a interface gráfica

---

## Criando o Projeto no NetBeans (Java with Gradle)

1. **Abrir o NetBeans 19**
2. **Criar um novo projeto**:
   - Clique em **File** > **New Project**.
   - Selecione **Java with Gradle** > **Java Application** e clique em **Next**.
   - No campo **Project Name**, digite `GerenciadorBiblioteca`.
   - Escolha um local para salvar e clique em **Finish**.

3. **Criar os Pacotes do Projeto**:
   - No painel **Projects**, expanda o projeto recém-criado.
   - Clique com o botão direito na pasta `src/main/java` > **New** > **Java Package**.
   - Crie os seguintes pacotes:
     - `model`: Para as classes que representarão os dados.
     - `view`: Para a interface com o usuário.
     - `controller`: Para a lógica de controle.
     - `database`: Para a conexão com o banco de dados.

4. **Adicionar Dependência do JDBC no `build.gradle`**:



---

## 🔧 ESTRUTURA EM CAMADAS

1. **Model**
2. **DAO (Data Access Object)**
3. **Controller**
4. **View**
5. **Services (opcional, mas recomendável em apps maiores)**
6. **Database (conexão)**

---

## ✅ 1. **MODEL**
### O que colocar:
- Classes que representam os **objetos da aplicação** (por exemplo: `Usuario`, `Produto`, `Cliente`).
- Apenas **atributos** e seus **getters/setters**.
- Pode conter **construtores** e **toString()**.

### O que não colocar:
- **Lógica de acesso ao banco**, **validações**, ou **regras de negócio**.

> 🧠 Exemplo: A classe `Usuario` só guarda `email` e `senha`, mais nada.

---

## ✅ 2. **DAO (Data Access Object)**
### O que colocar:
- Métodos que **acessam diretamente o banco de dados**:
  - `inserir()`
  - `buscarPorId()`
  - `listar()`
  - `atualizar()`
  - `deletar()`
- Uso de **`PreparedStatement`**, **`Connection`**, **`ResultSet`**, etc.

### O que não colocar:
- **Regras de negócio** (ex: não verificar se o usuário é administrador).
- **Tratamento de dados** que não tenha a ver com o banco.
- **Interação com a tela**.

> 🧠 O DAO é como uma “ponte direta” com o banco.

---

## ✅ 3. **CONTROLLER**
### O que colocar:
- Lógica de controle do sistema (decisões como: cadastrar ou não? validar dados?).
- Chamar o DAO quando for necessário.
- Pode fazer **validações simples** como "campo está vazio?" ou "senha tem pelo menos 6 caracteres?".

### O que não colocar:
- Código de **interface gráfica (Swing, JavaFX)**.
- **SQL ou banco de dados diretamente** (isso é função do DAO).

> 🧠 O controller coordena o que acontece quando o usuário clica num botão.

---

## ✅ 4. **VIEW**
### O que colocar:
- A **interface gráfica** do programa (telas, botões, campos, janelas).
- Eventos (ex: `btnLoginActionPerformed`).
- Coleta de dados dos campos e envio ao controller.

### O que não colocar:
- **SQL**
- **Acesso ao banco de dados**
- Regras de negócio complexas

> 🧠 A View apenas **exibe** e **coleta** informações do usuário.

---

## ✅ 5. **SERVICES** (opcional, mas recomendado)
> Usada em projetos maiores para separar **regras de negócio complexas** do controller.

### O que colocar:
- **Regras de negócio** mais elaboradas.
  - Ex: calcular desconto, validar CPF, lógica de permissões.

### O que não colocar:
- Código da interface ou SQL direto.
- Acesso ao banco (isso é função do DAO).

> 🧠 O service é o "cérebro" com a lógica de negócio real, deixando o controller leve.

---

## ✅ 6. **DATABASE** (configuração)
### O que colocar:
- Classe(s) de **conexão com o banco** de dados.
  - Ex: `Conexao.java` com `getConnection()`.

### O que não colocar:
- Nenhuma lógica de cadastro, validação ou visualização.
- Nenhum `JFrame`, `JButton`, etc.

---

## 📌 RESUMO DA RESPONSABILIDADE DE CADA CAMADA

| Camada     | Responsabilidade Principal                               | Exemplo de Conteúdo                      |
|------------|-----------------------------------------------------------|------------------------------------------|
| Model      | Representa os dados/entidades                            | Classe `Usuario` com atributos           |
| DAO        | Acesso ao banco (CRUD)                                   | `registrarUsuario()`, `buscarUsuario()`  |
| Controller | Intermediário entre view e DAO                           | `validarLogin()`, `atualizarSenha()`     |
| View       | Interface com o usuário                                  | Tela de login, campos, botões            |
| Service    | (Opcional) Regras de negócio complexas                   | `calcularDesconto()`, `verificarPermissao()` |
| Database   | Conexão com o banco                                      | `Conexao.java`                           |






