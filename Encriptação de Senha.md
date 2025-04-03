### 🔐 **O que é BCrypt e como funciona no Java?**  

O **BCrypt** é um algoritmo seguro para criptografar senhas antes de armazená-las no banco de dados. Ele ajuda a proteger as senhas contra **ataques de força bruta** e **dicionário**.  

No Java, usamos a biblioteca **JBcrypt**, que oferece métodos fáceis para **criar um hash** e **verificar uma senha**.

---

## 📌 **Principais Métodos do BCrypt**
A biblioteca tem três métodos principais:

1️⃣ **`BCrypt.gensalt(int log_rounds)`**  
   🔹 Gera um **salt** aleatório (um código que torna o hash mais seguro). O salt é um pedaço aleatório de dados que é adicionado a uma senha antes de ser criptografada.
   🔹 O número `log_rounds` define o "custo" do processamento (quanto maior, mais seguro).  
   🔹 Padrão seguro: **10 a 14** (se colocar 12, será mais lento e seguro).  

2️⃣ **`BCrypt.hashpw(String senha, String salt)`**  
   🔹 Usa a senha e o salt para gerar um **hash seguro**.  
   🔹 O hash é o valor criptografado que será armazenado no banco.

3️⃣ **`BCrypt.checkpw(String senhaDigitada, String hashArmazenado)`**  
   🔹 Compara a senha digitada com o hash salvo no banco.  
   🔹 Retorna **true** se for a senha correta e **false** se estiver errada.

---

## 📝 **Passo a Passo no Java**
Agora, vamos ver na prática como funciona o **hashing de senha com BCrypt**.

### Primeiro, adicione esta linha dentro de dependencies no build.gradle:
implementation 'org.mindrot:jbcrypt:0.4'

### 📌 **1️⃣ Gerar um Hash Seguro**
```java
import org.mindrot.jbcrypt.BCrypt;

public class ExemploBCrypt {
    public static void main(String[] args) {
        String senha = "minhaSenha123";  // Senha do usuário

        // Gera um salt (segurança extra) e faz o hash da senha
        String salt = BCrypt.gensalt(12);
        String senhaHash = BCrypt.hashpw(senha, salt);

        System.out.println("Senha original: " + senha);
        System.out.println("Senha criptografada: " + senhaHash);
    }
}
```

🔹 **Saída esperada (o hash será diferente a cada execução)**:  
```
Senha original: minhaSenha123
Senha criptografada: $2a$12$Zdfn1cX7A3pmXf.... (hash diferente toda vez)
```

---

### 📌 **2️⃣ Verificar a Senha Digitada**
Agora, vamos verificar se a senha que o usuário digitou é correta.

```java
import org.mindrot.jbcrypt.BCrypt;

public class VerificarSenha {
    public static void main(String[] args) {
        String senhaOriginal = "minhaSenha123";  // Senha do usuário
        String senhaErrada = "senhaIncorreta";   // Senha errada para testar

        // Geramos um hash seguro
        String hashSalvo = BCrypt.hashpw(senhaOriginal, BCrypt.gensalt(12));

        // Agora, verificamos se a senha está correta
        boolean senhaCorreta = BCrypt.checkpw(senhaOriginal, hashSalvo);
        boolean senhaIncorreta = BCrypt.checkpw(senhaErrada, hashSalvo);

        System.out.println("Senha correta? " + senhaCorreta);   // true
        System.out.println("Senha incorreta? " + senhaIncorreta); // false
    }
}
```

🔹 **Saída esperada**:  
```
Senha correta? true
Senha incorreta? false
```

---

## 🔎 **Resumo**
✅ **BCrypt** protege senhas com um algoritmo seguro.  
✅ O **salt** deixa cada senha única, evitando ataques de dicionário.  
✅ O hash **não pode ser revertido** (não dá para descobrir a senha original).  
✅ Para verificar uma senha, usamos **`BCrypt.checkpw()`**.  
