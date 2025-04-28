# Entendendo APIs para Java Desktop

# O que são APIs e por que usamos elas para nos comunicar com um servidor?

APIs, ou **Application Programming Interfaces** (em português, Interface de Programação de Aplicações), são como **pontes de comunicação** entre o seu programa e o servidor.

Imagine que seu programa é uma pessoa querendo informações, e o servidor é uma enorme biblioteca cheia de dados. A **API é o bibliotecário**, que entende seu pedido, procura o que você quer, e te entrega certinho.

Sem a API, o seu programa não saberia como pedir as informações corretamente. Cada servidor fala uma "língua" própria e a API traduz tudo isso.

---

## Como Funciona?

1. **Requisição**: Seu programa manda um pedido para o servidor usando a API, pedindo informações ou enviando dados.
2. **Processamento**: O servidor recebe o pedido, entende o que você quer, consulta suas informações e prepara a resposta.
3. **Resposta**: O servidor manda a resposta de volta para o seu programa, contendo as informações pedidas ou uma confirmação que deu tudo certo.

---

# Entendendo com um Exemplo de Vida Real: O Servidor de CEPs

Imagine que alguém já pesquisou **todos os CEPs** do Brasil, anotou os endereços corretos, e guardou tudo em um computador gigante (o **servidor**).

Agora, no seu programa Java Desktop, quando você quiser saber o endereço de um CEP, você **não precisa ir aos Correios nem pesquisar na internet**.  
Basta enviar uma mensagem para esse computador (servidor) pedindo:  
"Ei, me diga qual é o endereço do CEP 01001-000?"

O servidor então **procura** nos seus registros e **responde** para o seu programa:  
"Esse CEP corresponde à Praça da Sé, em São Paulo."

O **API** é o **garçom** que leva seu pedido até o servidor e traz a resposta para você!

---

# O que é JSON?

O servidor precisa mandar os dados de volta para o seu programa **de um jeito organizado**.

Para isso, ele geralmente usa um formato chamado **JSON** — que significa **JavaScript Object Notation**.

### Mas o que é JSON?

Imagine uma caixa cheia de etiquetas. Cada etiqueta tem um **nome** (chave) e um **valor**.  
Exemplo de resposta do servidor em JSON:

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

**Chave** é o que você está perguntando ("logradouro") e **valor** é a resposta ("Praça da Sé").

**Resumo**: JSON é só um **jeito organizado** de entregar as informações.

---

# Entendendo as Partes de uma Comunicação com o Servidor

Quando o seu programa se comunica com um servidor usando uma API, ele envia uma **requisição HTTP**.  
Essa requisição é dividida em **partes importantes**:

## 1. Método HTTP

O **método** indica **o que você quer fazer** com o servidor. É como dizer:

- Quero **buscar** algo! (GET)
- Quero **enviar** algo novo! (POST)
- Quero **atualizar** alguma coisa! (PUT)
- Quero **deletar** algo! (DELETE)

### Usando a metáfora:

Métodos HTTP são como **tipos de pedidos** que você faz ao bibliotecário (API):

| Método | Ação                                                    |
|-------|-----------------------------------------------------------|
| GET   | Quero ver uma informação que já existe.                   |
| POST  | Quero criar uma nova informação.                          |
| PUT   | Quero atualizar uma informação já existente.              |
| DELETE| Quero apagar uma informação existente.                   |

No caso do nosso programa de CEP, vamos usar o **GET**, porque só queremos **buscar** informações.

---

## 2. Cabeçalhos (Headers)

Os **cabeçalhos** são **informações extras** que vão junto com seu pedido.

Eles dizem ao servidor coisas como:

- "Olha, eu aceito respostas no formato JSON!"
- "Estou enviando esta informação como JSON!"

Exemplo de cabeçalho:

```
Accept: application/json
```

Significa: "Servidor, eu espero que você me responda em JSON, ok?"

---

## 3. Corpo da Requisição (Body)

O **corpo** é o conteúdo principal da mensagem, onde você coloca dados **se necessário**.

- Em requisições **GET**, normalmente não tem corpo — você só pede informações.
- Em requisições **POST** ou **PUT**, você envia dados no corpo.

Exemplo de corpo para criar um novo cadastro:

```json
{
  "nome": "João",
  "email": "joao@example.com"
}
```

No nosso programa de CEP, **não vamos precisar enviar corpo**, porque estamos apenas buscando um endereço!

---

# E a Resposta?

Depois que o servidor recebe seu pedido, ele manda uma **resposta**.

Assim como a requisição, a resposta tem:

- **Linha de Status**: Diz se deu certo ou errado.
  - Exemplo: `HTTP/1.1 200 OK` → Tudo certo!
  - Exemplo: `HTTP/1.1 404 Not Found` → Não achei o que você pediu!
  
- **Cabeçalhos**: Informações sobre o que está vindo.
  - Exemplo: `Content-Type: application/json`

- **Corpo**: O conteúdo que realmente importa (os dados).
  - Exemplo (o endereço retornado):

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

---

# Resumo Geral

✅ O seu programa (cliente) faz um pedido (requisição) ao servidor.  
✅ Usa um método HTTP para dizer o que quer fazer.  
✅ O servidor lê seu pedido, consulta seus dados, e envia a resposta.  
✅ Tudo é enviado de maneira organizada usando JSON.  
✅ Você pode pensar na API como o **garçom** ou o **bibliotecário** que ajuda seu programa a pegar as informações certas.

---

# Próximos Passos na Aula

Agora que você entendeu como funciona a comunicação:

✅ Vamos criar no **Java Desktop** um programa que:

- Recebe um CEP digitado pelo usuário.
- Faz uma requisição HTTP (GET) para uma API de CEPs.
- Recebe a resposta em JSON.
- Mostra o endereço na tela!

---

# Dica Final 🎯

Sempre lembre: **quando seu programa consulta um servidor**, ele está apenas **fazendo perguntas** e **lendo respostas**.  
A API ajuda a fazer essa conversa ficar **organizada**, **rápida** e **segura**!


---


