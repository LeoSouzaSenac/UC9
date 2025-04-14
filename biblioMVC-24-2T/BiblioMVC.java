/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bibliomvc;

import com.mycompany.bibliomvc.dao.BooksDAO;
import com.mycompany.bibliomvc.database.ConnectSQLite;
import com.mycompany.bibliomvc.database.CreateTables;

import com.mycompany.bibliomvc.model.Book;
import com.mycompany.bibliomvc.view.LibraryFrame;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Professor
 */
public class BiblioMVC {

    public static void main(String[] args) {
        
        new LibraryFrame().setVisible(true);
        
        
    }
}
