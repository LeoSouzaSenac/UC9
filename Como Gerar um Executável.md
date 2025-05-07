### 📦 Como Criar um `.jar` Executável no NetBeans com Maven

#### ✅ O que é o `Build`?

Ótima pergunta!

---

## 🛠️ O que é "Build"?

**Build** (em português: *compilar e montar*) é o processo de transformar seu **código-fonte** em um **programa executável**.

No caso do Java com Maven, o build:

1. **Compila** os arquivos `.java` (transforma em `.class`)
2. **Resolve dependências** (bibliotecas externas, como `okhttp`, `json`, etc.)
3. **Empacota tudo** num arquivo `.jar` (Java ARchive), que é como um "zip" com seu programa pronto para ser executado.

---

### 🧩 O que acontece durante o build:

| Etapa               | O que acontece                                                                |
| ------------------- | ----------------------------------------------------------------------------- |
| Compilação          | Transforma `.java` em `.class`                                                |
| Download de libs    | Baixa bibliotecas do Maven (ex: `okhttp`)                                     |
| Geração do `.jar`   | Empacota tudo em um único arquivo `.jar` para rodar com `java -jar`           |
| Criação do Manifest | Cria o arquivo `MANIFEST.MF` para indicar a classe principal (com o `main()`) |

---

### 🧪 Em resumo:

> **Build é o processo que transforma seu projeto Java em um programa pronto para ser executado.**


---

## 🧾 Por que o Java transforma `.java` em `.class`?

### 💡 Porque o computador **não entende diretamente código Java**!

O que acontece:

1. Você escreve código em **Java** (`.java`) – que é fácil de entender para humanos.
2. O **compilador do Java** transforma esse código em **bytecode**, que é salvo em arquivos `.class`.
3. O bytecode `.class` é **executado pela JVM** (Java Virtual Machine), que entende esse formato.

---

### 🔁 Exemplo simples

| Etapa       | Tipo de arquivo     | Quem entende         |
| ----------- | ------------------- | -------------------- |
| Código Java | `MeuPrograma.java`  | Você                 |
| Compilado   | `MeuPrograma.class` | JVM                  |
| Executado   | JVM roda `.class`   | Computador (via JVM) |

---

### 🤖 O que é a **JVM**?

A **Java Virtual Machine** é uma "máquina virtual" que roda seu programa Java.
Ela permite que o mesmo `.class` funcione em **Windows, Linux, macOS** etc.

> Por isso o Java é famoso por ser *"write once, run anywhere"* (escreva uma vez, rode em qualquer lugar).

---

### 🔐 Segurança e Portabilidade

Transformar `.java` em `.class` permite:

* **Segurança:** o código é validado antes de rodar.
* **Portabilidade:** roda em qualquer sistema com JVM.
* **Desempenho:** é mais rápido para a máquina interpretar bytecode do que texto puro.


### 🧩 A JVM faz parte do JDK e do JRE:

| Componente                         | Função principal                                 |
| ---------------------------------- | ------------------------------------------------ |
| **JDK** (Java Development Kit)     | Para programar em Java (inclui compilador + JVM) |
| **JRE** (Java Runtime Environment) | Para rodar programas Java (inclui apenas a JVM)  |




#### ✅ O que é o `MANIFEST.MF`?

O arquivo `MANIFEST.MF` é um arquivo especial que fica dentro do `.jar`. Ele informa ao Java **qual é a classe principal** do projeto — ou seja, **onde está o método `main()` que deve ser executado**.

Sem esse arquivo corretamente configurado, o Java não sabe por onde começar e dá erro ao rodar o `.jar`.

---

#### 🧱 O que deve ter no `pom.xml`

Para gerar um `.jar` com a classe principal definida, precisamos adicionar um plugin chamado `maven-jar-plugin`.

Aqui está um exemplo completo de `pom.xml` com essa configuração:

```xml
<build>
    <plugins>
        <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-assembly-plugin</artifactId>
    <version>3.3.0</version>
    <configuration>
        <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
        <archive>
            <manifest>
                <mainClass>com.mycompany.cepcomapi.CepComApi</mainClass>
            </manifest>
        </archive>
    </configuration>
    <executions>
        <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals>
                <goal>single</goal>
            </goals>
        </execution>
    </executions>
</plugin>

    </plugins>
</build>
```

> ⚠️ **Troque** `com.mycompany.cepcomapi.CepComApi` pelo nome completo da sua classe principal, a que tem o `public static void main(String[] args)`.

---

#### 🧪 Como gerar o `.jar` no NetBeans

1. **Abra seu projeto Maven no NetBeans**.
2. Clique com o **botão direito do mouse** no nome do projeto.
3. Clique em **"Construir"** (ou "Build").
4. O NetBeans vai gerar o `.jar`.

---

#### 📁 Onde está o `.jar`?

Depois de construir o projeto, o arquivo `.jar` estará dentro da pasta:

```
<seu_projeto>/target/
```

Exemplo:

```
cepComApi/target/cepComApi-1.0-SNAPSHOT.jar
```

---

#### ▶️ Como rodar o `.jar`

Abra um terminal e execute:

```bash
java -jar target/cepComApi-1.0-SNAPSHOT.jar
```

Se estiver tudo certo, seu programa vai rodar!
