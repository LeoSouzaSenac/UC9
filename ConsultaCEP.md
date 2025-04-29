# 📚 Projeto Java Swing com Padrão MVC e Consulta de CEP

Este projeto demonstra como criar uma aplicação Java usando o padrão **MVC (Model-View-Controller)** para consultar um CEP utilizando a API ViaCEP.

---

## 📂 Estrutura do Projeto

```
src/
└── com/mycompany/cepcomapi/
    ├── controller/
    │   └── CadastroController.java
    ├── model/
    │   └── Endereco.java
    ├── service/
    │   └── ViaCepService.java
    └── view/
        └── CadastroForm.java
```

---

## ⚙️ Configuração do `pom.xml`

Para realizar requisições HTTP e manipular JSON, adicionaremos as seguintes dependências no arquivo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>4.9.3</version>
    </dependency>
    <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20230227</version>
    </dependency>
</dependencies>
```

---

## 📄 Classe por Classe

---

### 🔷 **Model** – `Endereco.java`

> Representa os dados de endereço obtidos pela API.

```java
package com.mycompany.cepcomapi.model;

public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    // Construtor
    public Endereco(String rua, String bairro, String cidade, String estado) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Getters e Setters
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
```

---

### 🔷 **Service** – `ViaCepService.java`

> Responsável por fazer a requisição à API ViaCEP usando **OkHttp**.

```java
package com.mycompany.cepcomapi.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class ViaCepService {

    // Método para buscar dados de endereço pelo CEP
    public static JSONObject buscarCep(String cep) throws Exception {
        // Cria o cliente HTTP (OkHttpClient)
        OkHttpClient client = new OkHttpClient();

        // Cria a requisição GET com a URL montada com o CEP
        Request request = new Request.Builder()
            .url("https://viacep.com.br/ws/" + cep + "/json/")
            .build(); // .get() é opcional, pois GET é o método padrão

        // Executa a requisição e obtém a resposta
        try (Response response = client.newCall(request).execute()) {
            // Verifica se a requisição foi bem-sucedida (código 200)
            if (!response.isSuccessful()) {
                throw new Exception("Erro ao buscar CEP: " + response);
            }

            // Lê a resposta em formato de texto (JSON)
            String jsonData = response.body().string();

            // Converte a String em um objeto JSON para facilitar o acesso aos dados
            return new JSONObject(jsonData);
        }
    }
}
```

---

### 🔷 **Controller** – `CadastroController.java`

> Responsável por intermediar a **View** e o **Model** (lógica de negócio e validações).

```java
package com.mycompany.cepcomapi.controller;

import com.mycompany.cepcomapi.model.Endereco;
import com.mycompany.cepcomapi.service.ViaCepService;
import org.json.JSONObject;

public class CadastroController {

    // Valida o formato do e-mail usando expressão regular (Regex)
    public boolean emailValido(String email) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(regex);
    }

    // Busca o endereço pelo CEP e retorna um objeto Endereco ou null se houver erro
    public Endereco buscarEnderecoPorCep(String cep) throws Exception {
        JSONObject enderecoJson = ViaCepService.buscarCep(cep);

        // Verifica se a resposta contém a chave "erro" (CEP inválido)
        if (enderecoJson.has("erro")) {
            return null;
        }

        // Cria e retorna um objeto Endereco com os dados obtidos
        return new Endereco(
            enderecoJson.getString("logradouro"),
            enderecoJson.getString("bairro"),
            enderecoJson.getString("localidade"),
            enderecoJson.getString("uf")
        );
    }
}
```

---

### 🔷 **View** – `CadastroForm.java`

> Interface gráfica criada com Swing, responsável por interagir com o usuário.

```java
public class CadastroForm extends javax.swing.JFrame {
    
    private CadastroController controller = new CadastroController();
    /**
     * Creates new form CadastroForm
     */
    public CadastroForm() {
        initComponents();
    }

                            

    private void btnBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {                                             
         String cep = txtCep.getText().replace("-", "").trim();

        if (cep.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite um CEP válido!");
            return;
        }

        try {
            Endereco endereco = controller.buscarEnderecoPorCep(cep);

            if (endereco == null) {
                JOptionPane.showMessageDialog(this, "CEP não encontrado!");
            } else {
                txtRua.setText(endereco.getRua());
                txtBairro.setText(endereco.getBairro());
                txtCidade.setText(endereco.getCidade());
                txtEstado.setText(endereco.getEstado());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar CEP: " + ex.getMessage());
        }
    }                                            

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String email = txtEmail.getText().trim();

        if (!controller.emailValido(email)) {
            JOptionPane.showMessageDialog(this, "Digite um e-mail válido!");
            return;
        }

        JOptionPane.showMessageDialog(this, "Cadastro salvo com sucesso!");
    
    }  
```

---

## 🔧 Funcionamento do Programa

1. O usuário informa o **CEP** e clica em **"Buscar"**:
   - A `View` envia o CEP ao `Controller`.
   - O `Controller` consulta a API ViaCEP usando o `Service`.
   - O `Service` retorna os dados, que são convertidos em um objeto `Endereco`.
   - A `View` preenche os campos com o endereço ou exibe uma mensagem de erro.

2. O usuário informa o **e-mail** e clica em **"Salvar"**:
   - O `Controller` valida o e-mail.
   - Caso válido, uma mensagem de sucesso é exibida.

---

## 📌 Tecnologias Utilizadas

- Java (Swing)
- Padrão MVC
- API ViaCEP (https://viacep.com.br)
- Bibliotecas:
  - **OkHttp** (requisições HTTP)
  - **org.json** (manipulação de JSON)
