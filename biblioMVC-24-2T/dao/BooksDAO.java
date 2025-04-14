/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliomvc.dao;


import com.mycompany.bibliomvc.database.ConnectSQLite;
import com.mycompany.bibliomvc.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class BooksDAO {
    
   
    
    public static void addBook(Book myBook){
       String sql = "INSERT INTO books (title, author, price, year) VALUES (?,?,?,?)";
       
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
       
       try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
           pstmt.setString(1, myBook.getTitle());
           pstmt.setString(2, myBook.getAuthor());
           pstmt.setDouble(3, myBook.getPrice());
           pstmt.setInt(4, myBook.getYear());
           
           pstmt.executeUpdate();
           System.out.println("Book added to database.");
       
       } catch (SQLException error) {
           System.out.println("Error: " + error.getMessage());
       }
    }
    
    public static void updateBook(Book myBook) {
        String sql = "UPDATE books "
                + "SET title = ?, "
                + "author = ?, "
                + "price = ?, "
                + "year = ? "
                + "WHERE id = ?";
        
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        
       try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
           pstmt.setString(1, myBook.getTitle());
           pstmt.setString(2, myBook.getAuthor());
           pstmt.setDouble(3, myBook.getPrice());
           pstmt.setInt(4, myBook.getYear());
           pstmt.setInt(5, myBook.getId());
           
           int rowsUpdated = pstmt.executeUpdate();
           if (rowsUpdated > 0) {
               System.out.println("Book found. Values updated.");
           } else {
               System.out.println("ID not found. Please select a valid ID.");
           }
       
       } catch (SQLException error) {
           System.out.println("Error: " + error.getMessage());
       }
        
        
    }

    public static void deleteBook(int id){
        String sql = "DELETE FROM books WHERE id = ?";
        
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            int rowsDeleted = pstmt.executeUpdate();
            
            if(rowsDeleted > 0) {
                System.out.println("ID found. The book was deleted.");
            } else {
                System.out.println("ID not found. Please select a valid id.");
            }
        }
        catch(SQLException error) {
            System.out.println("Error: " + error.getMessage());
        }
        
    }

    public static String[] findBook(String nome){
        String sql = "SELECT * FROM books WHERE title = ?";
        String[] info = new String[5];
        
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                
                info[0] = rs.getString("id");
                info[1] = rs.getString("title");
                info[2] = rs.getString("author");
                info[3] = rs.getString("price");
                info[4] = rs.getString("year");
                System.out.println("Book found in database.");
            } else {
                System.out.println("ID not found. Please select a valid ID.");
            }
            
        } catch (SQLException error){
            System.out.println("Error: " + error.getMessage());
        }
        
        return info;
    }
    
    
    public static ArrayList<Book> findBooks() {
        String sql = "SELECT * FROM books";
        ArrayList<Book> info = new ArrayList<>();
        
        ConnectSQLite connectSQLite = new ConnectSQLite();
        Connection connection = connectSQLite.connect();
        
        try(Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Book myBook = new Book(
                rs.getString("title"),
                rs.getString("author"),
                rs.getDouble("price"),
                rs.getInt("year")
                );
                // Como não passo o ID no construtor do livro, eu preciso chamar o método setID para passar o ID
                myBook.setId(rs.getInt("id"));
                info.add(myBook);
                
            }
            
        } catch(SQLException error) {
            System.out.println("Error: " + error.getMessage());
        }
        
        return info;
    }
}
