Primeiro de tudo, crie um projeto chamado "loginComHash" no NetBeans.
Depois, crie a estrutura de projeto de acordo com a imagem:
<img width="155" alt="Captura de tela 2025-04-11 180233" src="https://github.com/user-attachments/assets/7fe58ece-94b5-4b2c-87fe-e46f708981b4" />


# ⚙️ Configurando as Dependências no `build.gradle`

Para que seu projeto funcione corretamente com banco de dados, variáveis de ambiente e segurança de senhas, você precisa adicionar **algumas bibliotecas (dependências)** no seu `build.gradle`.

---

## 📌 Onde colocar?

Abra o arquivo `build.gradle` (geralmente fica na raiz do projeto) e adicione as linhas abaixo dentro do bloco `dependencies { }`:

```groovy
dependencies {
    implementation group: 'mysql', name: 'mysql-connector-java', version: '8.0.33'
    implementation group: 'org.mindrot', name: 'jbcrypt', version: '0.4'
    implementation 'io.github.cdimascio:dotenv-java:2.2.4'
}
```

Depois de salvar, o Gradle vai baixar automaticamente essas bibliotecas.

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


