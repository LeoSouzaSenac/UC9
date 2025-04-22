### 🎯 **Projeto: Gerenciador de Tarefas (Task Manager)**
📌 **Descrição:**  
Os grupos desenvolverão um sistema onde os usuários podem adicionar, editar, excluir e listar tarefas. Cada tarefa terá um título, descrição, data de vencimento e status (pendente/concluído).

---



## 📂 Estrutura do Projeto - MVC

```
📁 **taskManager**  
├── 📁 **model**  
│   ├── `Task.java`  
│   └── `User.java`  
│  
├── 📁 **view**  
│   ├── `MainView.java`        // Tela principal com botões e lista de tarefas  
│   └── `TaskForm.java`        // Tela para adicionar/editar/excluir tarefas  
│  
├── 📁 **controller**  
│   ├── `TaskController.java`  
│   └── `UserController.java`  
│  
├── 📁 **database**  
│   ├── `ConnectionSQL.java`  
│   └── `CreateTables.java`  
│  
├── 📁 **dao**  
│   ├── `TaskDAO.java`  
│   └── `UserDAO.java`  
│  
└── `Main.java`                // Classe principal que inicia o programa e chama a view principal  
```


---

### 📌 **Tabelas Necessárias para o Banco de Dados (SQLite)**  

Para armazenar as tarefas do **Task Manager**, precisamos de pelo menos uma tabela chamada **`tasks`**. Se você desejar, também pode adicionar uma tabela de usuários caso o sistema suporte multiusuários.

---

## 🔹 **1. Tabela `tasks`**  
Armazena as tarefas criadas pelos usuários.

```sql
CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    data_vencimento DATE,
    status ENUM('pendente', 'concluido') DEFAULT 'pendente'
);
```

### 🛠 **Explicação dos Campos**  
- **`id`** → Identificador único da tarefa.  
- **`title`** → Nome da tarefa.  
- **`description`** → Detalhes sobre a tarefa.  
- **`exp_date`** → Prazo para concluir a tarefa.  
- **`status`** → Define se a tarefa está pendente ou concluída.  

---

## 🔹 **2. (Opcional) Tabela `users`**  
Se quiser permitir múltiplos usuários no sistema, podemos criar uma tabela de usuários e relacionar as tarefas a um usuário específico.

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

### 🛠 **Explicação dos Campos**  
- **`id`** → Identificador único do usuário.  
- **`name`** → Nome do usuário.  
- **`email`** → E-mail único para login.  
- **`password`** → Senha do usuário.  

---

## 🔹 **3. (Opcional) Relacionamento entre `usuarios` e `tarefas`**  
Caso cada usuário tenha suas próprias tarefas, lembre que você deve adicionar um campo **`user_id`** na tabela `tasks` e criar uma chave estrangeira.
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
✅ Banco de Dados (MySQL) 

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
