### 🎯 **Projeto: Gerenciador de Tarefas (Task Manager)**
📌 **Descrição:**  
Os grupos desenvolverão um sistema onde os usuários podem adicionar, editar, excluir e listar tarefas. Cada tarefa terá um título, descrição, data de vencimento e status (pendente/concluído).

---

## 📂 **Estrutura do Projeto seguindo o MVC**  
🟢 **Model (Modelo):** Representa os dados e a lógica do negócio.  
🔵 **View (Visão):** Interface gráfica para interação do usuário (JavaFX ou Swing).  
🟠 **Controller (Controlador):** Manipula as interações do usuário e a lógica de aplicação.

📁 **ProjetoMVC_Tasks**  
 ├── 📁 `model` → (Contém as classes que representam os dados)  
 │   ├── `Tarefa.java`  
 │   ├── `TarefaDAO.java` *(Se usar persistência em banco de dados ou arquivo JSON)*  
 ├── 📁 `view` → (Interface gráfica para o usuário)  
 │   ├── `MainView.java` *(Tela principal com botões e lista de tarefas)*  
 │   ├── `TarefaForm.java` *(Tela para adicionar/editar tarefas)*  
 ├── 📁 `controller` → (Gerencia a comunicação entre a View e o Model)  
 │   ├── `TarefaController.java`  
 ├── `Main.java` *(Classe principal para iniciar o programa)*  

---

### 📌 **Tabelas Necessárias para o Banco de Dados (SQLite)**  

Para armazenar as tarefas do **Gerenciador de Tarefas**, precisamos de pelo menos uma tabela chamada **`tarefas`**. Se você desejar, também pode adicionar uma tabela de usuários caso o sistema suporte multiusuários.

---

## 🔹 **1. Tabela `tarefas`**  
Armazena as tarefas criadas pelos usuários.

```sql
CREATE TABLE tarefas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    data_vencimento DATE,
    status ENUM('pendente', 'concluido') DEFAULT 'pendente'
);
```

### 🛠 **Explicação dos Campos**  
- **`id`** → Identificador único da tarefa.  
- **`titulo`** → Nome da tarefa.  
- **`descricao`** → Detalhes sobre a tarefa.  
- **`data_vencimento`** → Prazo para concluir a tarefa.  
- **`status`** → Define se a tarefa está pendente ou concluída.  

---

## 🔹 **2. (Opcional) Tabela `usuarios`**  
Se quiser permitir múltiplos usuários no sistema, podemos criar uma tabela de usuários e relacionar as tarefas a um usuário específico.

```sql
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);
```

### 🛠 **Explicação dos Campos**  
- **`id`** → Identificador único do usuário.  
- **`nome`** → Nome do usuário.  
- **`email`** → E-mail único para login.  
- **`senha`** → Senha do usuário.  

---

## 🔹 **3. (Opcional) Relacionamento entre `usuarios` e `tarefas`**  
Caso cada usuário tenha suas próprias tarefas, lembre que você deve adicionar um campo **`usuario_id`** na tabela `tarefas` e criar uma chave estrangeira.
Isso garante que cada tarefa pertence a um usuário específico.

---

## 🔹 **Funcionalidades**
✔ Criar uma nova tarefa  
✔ Listar tarefas existentes  
✔ Editar tarefas  
✔ Excluir tarefas  
✔ Marcar tarefa como concluída  
✔ Salvar as tarefas no banco de dados 

---

## 🛠 **Tecnologias**
✅ Java  
✅ Java Swing (Interface gráfica)  
✅ Banco de Dados (SQLite) 

---

## 📝 **Explicação do Fluxo**
1. O **usuário** adiciona uma nova tarefa através da **View**.  
2. A **View** chama o **Controller**, que valida os dados e solicita ao **Model** que armazene as informações.  
3. O **Model** processa os dados e os armazena (em memória, arquivo ou banco de dados).  
4. O **Controller** informa à **View** que os dados foram atualizados, e a interface é recarregada.  

---

### 🔥 **Extras para Desafiar Você**
- Implementar filtro por status (pendente/concluído).  
- Ordenação por data de vencimento.
