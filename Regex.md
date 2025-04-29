# O que é Regex (Expressão Regular)?

**Regex** (ou **expressão regular**) é uma **sequência de caracteres** que define um padrão de busca. Em outras palavras, é uma ferramenta usada para **procurar, combinar ou substituir** textos dentro de strings, de acordo com uma **regra ou padrão** que você define.

---

## Como funciona?

- **Regex** trabalha como uma **fórmula** que descreve padrões. Por exemplo, você pode criar uma regra para buscar todos os números em uma string ou verificar se uma palavra começa com uma letra maiúscula.
- Cada **símbolo ou conjunto de caracteres** dentro de uma regex tem um significado especial que ajuda a encontrar ou manipular o texto de forma mais flexível.

---

## Exemplos de como Regex pode ser usado:

### 1. **Verificar e-mails**:
Uma regex pode ser usada para garantir que uma string tenha o formato de um e-mail válido, com `@` e domínio, por exemplo.

### 2. **Procurar números em um texto**:
Se você tiver um texto e quiser achar todos os números dentro dele, pode usar uma regex como `\\d+`, que significa "encontre um ou mais dígitos" (onde `\\d` é um número e `+` significa "um ou mais").

### 3. **Substituir palavras**:
Você pode usar regex para substituir todas as ocorrências de uma palavra em um texto. Por exemplo, substituir "gato" por "cachorro".

---

## Por que usar Regex?

- **Eficiência**: Permite fazer buscas e manipulações de texto muito rapidamente.
- **Flexibilidade**: Você pode definir regras muito complexas para buscar padrões exatos.
- **Precisão**: Com regex, você pode ser muito específico, por exemplo, só encontrar números de telefone, ou apenas e-mails que terminam com `.com`.

---

## Conclusão

**Regex é uma linguagem poderosa** usada para buscar e manipular textos de maneira eficiente, flexível e precisa.


Vamos analisar detalhadamente o **regex** usado na função `emailValido` para validar um e-mail:

```java
String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
```

Esse regex tem o objetivo de verificar se uma string tem o **formato típico de um e-mail**. Aqui está a explicação por partes:

---

### 🔍 **Parte a parte do regex:**

#### `^`
- **Início da string**: Garante que a validação começa do início da string.

---

#### `[\\w-\\.]+`
- Esse trecho valida a **parte antes do @** (ex: `nome.usuario-123`).
- `[\\w-\\.]` significa:
  - `\\w`: qualquer caractere alfanumérico (letras e números) e **underscore** (`_`)
  - `-`: hífen (precisa estar fora das extremidades ou escapado)
  - `\\.`: ponto (precisa ser escapado porque o ponto tem significado especial no regex)
- `+`: um ou mais desses caracteres.

---

#### `@`
- Literalmente o símbolo arroba, separa o usuário do domínio.

---

#### `([\\w-]+\\.)+`
- Essa parte valida **o domínio**, como por exemplo: `gmail.` ou `senac.sp.`.
- `[\\w-]+`: uma sequência de letras, números, underscore ou hífen.
- `\\.`: ponto (novamente, escapado).
- `(...) +`: esse grupo pode aparecer **uma ou mais vezes**, o que permite domínios como `senac.sp.com`.

---

#### `[\\w-]{2,4}`
- Essa parte representa a **extensão final do domínio**, como `com`, `net`, `org`, etc.
- `[\\w-]{2,4}`:
  - aceita de **2 a 4 caracteres** entre letras, números, hífen ou underscore.
  - exemplos válidos: `com`, `org`, `edu`

---

#### `$`
- **Fim da string**: garante que não haja caracteres extras depois da extensão do domínio.

---

### ✅ Exemplos válidos:

- `usuario@gmail.com`
- `nome.usuario-123@empresa.net`
- `meu_email@senac.sp.edu`
