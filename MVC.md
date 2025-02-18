# Introdução ao Padrão MVC e Criação do Projeto no NetBeans

## O que é o Padrão MVC?

O padrão MVC (Model-View-Controller) é uma forma organizada de estruturar um software dividindo-o em três partes principais:

- **Model (Modelo):** Responsável pelos dados e regras de negócio.
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
  




