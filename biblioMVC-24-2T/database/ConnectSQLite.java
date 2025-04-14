/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bibliomvc.database;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class ConnectSQLite {

    public Connection connect() {
        Connection connection = null; // Esta variável recebe a conexão. É ela que meu método retorna
        String url = "jdbc:sqlite:library.db";
        try{
            connection = DriverManager.getConnection(url);
            System.out.println("Succesfully connected to database.");
        }
        catch(SQLException error) {
            System.out.println("Error: " + error.getMessage());
        }
        
        return connection;
    }

    public void disconnect(Connection connection) {
        if (connection != null) {
            try{
                connection.close();
                System.out.println("Connection closed.");
            }
            catch (SQLException error) {
               System.out.println("Error: " + error.getMessage());
            }
        } else {
            System.out.println("Connection not found.");
        }
    }

}
