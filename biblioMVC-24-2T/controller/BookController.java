/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliomvc.controller;

import com.mycompany.bibliomvc.dao.BooksDAO;
import com.mycompany.bibliomvc.model.Book;
import com.mycompany.bibliomvc.view.LibraryFrame;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Professor
 */
public class BookController {

    private static ArrayList<Book> currentBooks = new ArrayList<>();
    private static String[] bookFound = new String[5];

    public static void addBook(String title, String author, String priceStr, String yearStr) {

        // Conversão de texto para tipos corretos
        double price = Double.parseDouble(priceStr);
        int year = Integer.parseInt(yearStr);

        // Cria o objeto Book com os dados recebidos
        Book myBook = new Book(title, author, price, year);

        BooksDAO.addBook(myBook);

    }

    public static void updateBook(int id, String newTitle, String newAuthor, String newPrice, String newYear) {

        double price = Double.parseDouble(newPrice);
        int year = Integer.parseInt(newYear);

        Book myBook = new Book(newTitle, newAuthor, price, year);
        myBook.setId(id);

        BooksDAO.updateBook(myBook);

    }

    public static Book getBookByIndex(int index) {
        if (index >= 0 && index < currentBooks.size()) {
            return currentBooks.get(index); //retorna o índice do livro no meu ArrayList
        }
        return null;
    }

    // Método que recebe os dados de BooksDAO e os formata para enviarmos para a view 
    public static ArrayList<String> loadBooks() {

        ArrayList<String> formattedList = new ArrayList<>();

        // Pega a lista de Books do BooksDAO
        currentBooks = BooksDAO.findBooks();

        // Formata para enviar para o outro arrayList e assim poder usar na view
        for (Book book : currentBooks) {
            String details = "ID: " + book.getId() + " | "
                    + "Title: " + book.getTitle() + " | "
                    + "Author: " + book.getAuthor() + " | "
                    + "Price: $" + book.getPrice() + " | "
                    + "Year: " + book.getYear();
            formattedList.add(details);
        }

        return formattedList;
    }

    // Método que recebe os dados de BooksDAO e os formata para enviarmos para a view 
    public static String searchBook(String titulo) {

        bookFound = BooksDAO.findBook(titulo); // meu array bookFound recebe o retorno do método de DAO
        // ["13", "Livro Tal", "Joana", "99.99", "2030"]
        
        currentBooks.clear();
        
        Book foundBook = new Book(
                bookFound[1],// Livro Tal
                bookFound[2], // Joana
                Double.parseDouble(bookFound[3]), // 99.99
                Integer.parseInt(bookFound[4]) // 2030
        );
        foundBook.setId(Integer.parseInt(bookFound[0])); // ID
        
        currentBooks.add(foundBook); 

        String details = "ID: " + bookFound[0] + " | "
                + "Title: " + bookFound[1] + " | "
                + "Author: " + bookFound[2] + " | "
                + "Price: $" + bookFound[3] + " | "
                + "Year: " + bookFound[4];

        return details; // ID 13 | Title Livro Tal | Author Joana | Price 99.99 | Year 2030
    }

    public static void deleteBookById(int id) {

        BooksDAO.deleteBook(id);

    }

}
