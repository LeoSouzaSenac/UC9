# 📌 A View no Padrão MVC

## ✅ Introdução
A **View** é a parte da aplicação responsável por exibir informações para o usuário e permitir interação com o sistema. No nosso projeto, que é um **Gerenciador de Biblioteca**, a View será a interface gráfica onde o usuário poderá cadastrar, visualizar, editar e excluir livros.

No NetBeans, utilizamos o **GUI Builder**, que permite a criação da interface gráfica **arrastando e soltando componentes**, sem precisar escrever todo o código manualmente. Entretanto, isso também **limita** algumas partes do código que podem ser editadas diretamente.

---

## 🎨 Criando a Interface Gráfica no NetBeans
Vamos criar uma tela para o cadastro de livros. Essa tela terá:
- **JLabels** para exibir "Título", "Autor" e "Ano de Publicação".
- **JTextFields** para entrada do título e autor.
- **JSpinner** para entrada do ano de publicação.
- **JButton** para salvar o livro.

### 🚀 Passos para Criar a Tela de Cadastro de Livros:
1. No NetBeans, vá até **File > New > JFrame Form**.
2. Dê um nome para a tela, por exemplo, `TelaCadastroLivro`.
3. No modo de design (GUI Builder), arraste e solte os seguintes componentes:
   - **3 JLabels** para os textos "Título", "Autor" e "Ano de Publicação".
   - **2 JTextFields** para entrada do título e do autor.
   - **1 JSpinner** para o ano de publicação.
   - **1 JButton** para salvar o livro.
4. Ajuste os textos dos componentes usando a aba **Properties**.
5. Organize os elementos na tela conforme necessário.

Agora a tela está pronta, mas ainda não faz nada. Precisamos adicionar eventos aos botões!

---

## 🔗 Conectando a View ao Controller
### Criando a ação do botão "Salvar"
1. **Clique duas vezes** no botão "Salvar". Isso abrirá o editor de código na seção do evento "ActionPerformed".
2. Dentro do método gerado, escreva o código para capturar os dados inseridos pelo usuário:

```java
private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {  
    String titulo = txtTitulo.getText();
    String autor = txtAutor.getText();
    int ano = (int) spinnerAno.getValue();
    
    // Criando um objeto Livro com os dados fornecidos pelo usuário
    Livro livro = new Livro(0, titulo, autor, ano);
    
    // Chamando o Controller para salvar no banco de dados
    LivroController controller = new LivroController();
    controller.salvarLivro(livro);
    
    JOptionPane.showMessageDialog(this, "Livro salvo com sucesso!");
}
```

📌 **Explicação:**
- Pegamos os valores digitados nos campos de texto.
- Criamos um objeto `Livro` com os dados digitados.
- Chamamos o `LivroController` para salvar no banco.
- Exibimos uma mensagem de sucesso para o usuário.

---

## 🔄 Atualizando a Tabela de Livros
Se tivermos uma **tabela (JTable)** para exibir os livros cadastrados, precisamos atualizar essa tabela sempre que um novo livro for salvo.

1. **Adicione um JTable** à interface.
2. **Defina as colunas**: `ID`, `Título`, `Autor`, `Ano`.
3. **No código, crie um método para carregar os dados na tabela**:

```java
private void carregarLivrosNaTabela() {
    DefaultTableModel modelo = (DefaultTableModel) tabelaLivros.getModel();
    modelo.setRowCount(0); // Limpa a tabela antes de recarregar os dados
    
    LivroController controller = new LivroController();
    List<Livro> livros = controller.buscarTodosLivros();
    
    for (Livro livro : livros) {
        modelo.addRow(new Object[]{livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAnoPublicacao()});
    }
}
```

📌 **Explicação:**
- `DefaultTableModel` permite adicionar e remover linhas na tabela.
- `setRowCount(0)` limpa a tabela antes de adicionar os novos registros.
- `controller.buscarTodosLivros()` busca os livros do banco de dados e os adiciona na tabela.

Para que a tabela atualize automaticamente, chamamos esse método **depois de salvar um livro**:

```java
private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {  
    // Código para salvar o livro...
    carregarLivrosNaTabela();
}
```

---

## 🔥 Conclusão
- A **View** exibe as informações e permite a interação do usuário.
- No NetBeans, usamos o **GUI Builder** para criar a interface sem precisar escrever código manualmente.
- Conectamos a interface gráfica ao **Controller**, que gerencia as ações do usuário.
- Atualizamos a tabela de livros automaticamente após cada alteração.

Agora estamos prontos para integrar tudo e finalizar o CRUD! 🚀

