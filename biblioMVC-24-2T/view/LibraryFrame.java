/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.bibliomvc.view;

import com.mycompany.bibliomvc.controller.BookController;
import com.mycompany.bibliomvc.model.Book;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class LibraryFrame extends javax.swing.JFrame {

    DefaultListModel<String> model = new DefaultListModel<>();

    /**
     * Creates new form LibraryFrame
     */
    public LibraryFrame() {
        initComponents();
        libraryList.setModel(model);
        updateList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleField = new javax.swing.JTextField();
        authorField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();
        yearField = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        libraryList = new javax.swing.JList<>();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        titleField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titleField.setText("Title");

        authorField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        authorField.setText("Author");

        priceField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceField.setText("Price");

        yearField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        yearField.setText("Year");

        addBtn.setBackground(new java.awt.Color(153, 255, 153));
        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(153, 255, 255));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        removeBtn.setBackground(new java.awt.Color(255, 153, 153));
        removeBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        removeBtn.setText("Remove");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });

        libraryList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1 Livro 1 Leo 99.99 2000" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(libraryList);

        updateBtn.setBackground(new java.awt.Color(255, 204, 102));
        updateBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(93, 93, 93)
                        .addComponent(removeBtn))
                    .addComponent(priceField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(authorField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addComponent(titleField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String title = titleField.getText();
        String author = authorField.getText();
        String price = priceField.getText();
        String year = yearField.getText();

        BookController.addBook(title, author, price, year);
        updateList();
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String title = titleField.getText();
        String author = authorField.getText();
        String price = priceField.getText();
        String year = yearField.getText();
        
        
        int selectedIndex = libraryList.getSelectedIndex();

        if (selectedIndex != -1) {
            Book selectedBook = BookController.getBookByIndex(selectedIndex);

            if (selectedBook != null) {
                int id = selectedBook.getId();
                BookController.updateBook(id, title, author, price, year);
                JOptionPane.showMessageDialog(this, "Book was updated.");
                updateList();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book to update.");
        }


    }//GEN-LAST:event_updateBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        int selectedIndex = libraryList.getSelectedIndex();
        if (selectedIndex != -1) {
            Book selectedBook =  BookController.getBookByIndex(selectedIndex);

            if (selectedBook != null) {
                int id = selectedBook.getId();
                BookController.deleteBookById(id); // this method below
                JOptionPane.showMessageDialog(this, "Book was deleted.");
                updateList();

            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book to delete.");
        }
    }//GEN-LAST:event_removeBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String title = titleField.getText();
        String bookFound = BookController.searchBook(title); // ID 13 | Title Livro Tal | Author Joana | Price 99.99 | Year 2030
        model.clear();
        model.addElement(bookFound);
        
    }//GEN-LAST:event_searchBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LibraryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibraryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibraryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibraryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibraryFrame().setVisible(true);
            }
        });
    }

    public void updateList() {
        model.clear(); // limpa a lista atual
        ArrayList<String> books = BookController.loadBooks();
        // adiciona cada livro formatado na lista do modelo
        for (String book : books) {
            model.addElement(book);
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField authorField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> libraryList;
    private javax.swing.JTextField priceField;
    private javax.swing.JButton removeBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField titleField;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}
