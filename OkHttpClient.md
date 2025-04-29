### 📦 `OkHttpClient` – O Cliente HTTP

O `OkHttpClient` é **uma classe da biblioteca OkHttp** (uma das bibliotecas Java mais populares para acessar a internet).

#### 📘 O que ele faz?

Ele é **o responsável por enviar requisições HTTP e receber as respostas**. Pense nele como o "carteiro" do seu programa:

- Ele leva uma carta (requisição) até um servidor (por exemplo, a API do ViaCEP);
- Aguarda a resposta;
- Traz de volta para o seu código.

#### Exemplo:
```java
OkHttpClient client = new OkHttpClient();
```
> Isso cria um novo "carteiro" pronto para enviar e receber dados da internet.

---

### ✉️ `Request` – A Requisição

A classe `Request` representa **a carta que você quer enviar para o servidor**.

#### 📘 O que ela contém?

- O **endereço (URL)** do servidor (como o CEP que você quer consultar).
- Outras informações opcionais, como cabeçalhos, tipo de método (GET, POST, etc.).

#### Exemplo:
```java
Request request = new Request.Builder()
    .url("https://viacep.com.br/ws/" + cep + "/json/")
    .build();
```

> Isso constrói uma requisição do tipo **GET** para a URL `https://viacep.com.br/ws/01001-000/json/` (se o CEP fosse 01001-000).

---

### Como tudo funciona junto?

1. Você monta a **requisição** (`Request`) com o endereço da API e o CEP.
2. Você usa o **cliente HTTP** (`OkHttpClient`) para enviar essa requisição.
3. O servidor responde com um JSON contendo os dados do endereço.
4. O código converte esse JSON em um `JSONObject` para ser usado facilmente no seu programa.
