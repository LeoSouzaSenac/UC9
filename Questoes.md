# 🖥️ 15 Perguntas sobre Java Swing

1. Qual classe representa uma janela básica em Java Swing?  
   <details><summary>Resposta</summary> JFrame</details>

2. Qual método torna um `JFrame` visível na tela?  
   <details><summary>Resposta</summary> setVisible(true)</details>

3. Qual componente é usado para exibir uma linha de texto que o usuário **não pode editar**?  
   <details><summary>Resposta</summary> JLabel</details>

4. O que faz o método `setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)`?  
   <details><summary>Resposta</summary> Fecha o programa ao fechar a janela</details>

5. Qual componente é ideal para **inserir várias linhas de texto**?  
   <details><summary>Resposta</summary> JTextArea</details>

6. Qual é o objetivo do `JButton`?  
   <details><summary>Resposta</summary> Criar um botão</details>

7. Qual classe é usada para agrupar vários componentes?  
   <details><summary>Resposta</summary> JPanel</details>

8. Qual é o gerenciador de layout padrão de um `JFrame`?  
   <details><summary>Resposta</summary> BorderLayout</details>

9. Para adicionar um evento a um botão, usamos:  
   <details><summary>Resposta</summary> ActionListener</details>

10. Qual método adiciona um componente a um container?  
    <details><summary>Resposta</summary> add()</details>

11. Para mudar o texto de um `JLabel`, usamos:  
    <details><summary>Resposta</summary> setText()</details>

12. Qual classe permite criar caixas de diálogo (ex: alertas)?  
    <details><summary>Resposta</summary> JOptionPane</details>

13. Qual componente é usado para **selecionar itens de uma lista suspensa**?  
    <details><summary>Resposta</summary> JComboBox</details>

14. O `setBounds(x, y, width, height)` é usado para:  
    <details><summary>Resposta</summary> Posicionar um componente manualmente</details>

15. Swing é uma biblioteca:  
    <details><summary>Resposta</summary> Gráfica e parte da biblioteca padrão do Java</details>

---

# 🗄️ 15 Perguntas sobre Java com JDBC (MySQL)

1. O que significa JDBC?  
   <details><summary>Resposta</summary> Java Database Connectivity</details>

2. Qual classe usamos para estabelecer uma conexão com o MySQL?  
   <details><summary>Resposta</summary> Connection</details>

3. Qual driver usamos para MySQL em JDBC?  
   <details><summary>Resposta</summary> com.mysql.jdbc.Driver</details>

4. Qual método é usado para criar a conexão?  
   <details><summary>Resposta</summary> DriverManager.getConnection()</details>

5. O que é um `PreparedStatement`?  
   <details><summary>Resposta</summary> Uma forma segura de executar comandos SQL</details>

6. Qual é a função do `ResultSet`?  
   <details><summary>Resposta</summary> Guardar resultados de consultas</details>

7. Qual comando fecha a conexão com o banco?  
   <details><summary>Resposta</summary> close()</details>

8. Para evitar SQL Injection, é melhor usar:  
   <details><summary>Resposta</summary> PreparedStatement</details>

9. Um exemplo de conexão correta seria:  
   <details><summary>Resposta</summary> Verdadeiro</details>

10. Para executar um `INSERT`, usamos:  
    <details><summary>Resposta</summary> executeUpdate()</details>

11. Qual método é utilizado para executar um `SELECT` com `PreparedStatement`?  
    <details><summary>Resposta</summary> executeQuery()</details>

12. O que acontece se você não fechar a conexão?  
    <details><summary>Resposta</summary> Pode causar vazamentos de memória e travamentos</details>

13. Para percorrer um `ResultSet`, usamos:  
    <details><summary>Resposta</summary> while(rs.next())</details>

14. Para carregar o driver do MySQL manualmente (em versões antigas):  
    <details><summary>Resposta</summary> Class.forName("com.mysql.jdbc.Driver");</details>

15. A string de conexão sempre começa com:  
    <details><summary>Resposta</summary> jdbc:</details>

---

# 🧠 15 Perguntas sobre Arquitetura MVC em Java

1. O que o padrão MVC significa?  
   <details><summary>Resposta</summary> Model-View-Controller</details>

2. A responsabilidade do **Model** é:  
   <details><summary>Resposta</summary> Representar e manipular os dados</details>

3. A **View** é responsável por:  
   <details><summary>Resposta</summary> Exibir dados e interface gráfica</details>

4. O **Controller** faz:  
   <details><summary>Resposta</summary> Controla a interação entre View e Model</details>

5. MVC ajuda a:  
   <details><summary>Resposta</summary> Separar responsabilidades e facilitar a manutenção</details>

6. Qual camada deve **validar os dados** antes de enviar ao banco?  
   <details><summary>Resposta</summary> Controller</details>

7. A classe DAO geralmente pertence a qual camada?  
   <details><summary>Resposta</summary> Model</details>

8. O Controller deve:  
   <details><summary>Resposta</summary> Fazer a ponte entre entrada do usuário e atualização do Model</details>

9. Em um projeto Java com MVC, o botão da View deve chamar:  
   <details><summary>Resposta</summary> Controller</details>

10. A principal vantagem do padrão MVC é:  
    <details><summary>Resposta</summary> Organização e separação de responsabilidades</details>

11. O Model deve ter:  
    <details><summary>Resposta</summary> A lógica de negócio</details>

12. Qual é a ordem natural de fluxo de dados no MVC?  
    <details><summary>Resposta</summary> View → Controller → Model</details>

13. É correto o Controller acessar diretamente o banco de dados?  
    <details><summary>Resposta</summary> Não, ele deve usar o DAO</details>

14. O MVC facilita o trabalho em equipe porque:  
    <details><summary>Resposta</summary> Permite separar tarefas por camadas</details>

15. Para criar um campo de texto com um botao, na **View**, no mínimo, precisamos do que?  
    <details><summary>Resposta</summary> JFrame com JTextField e JButton</details>
