package com.library.view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.io.IOException;
import java.text.*;
import java.util.List;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.library.controller.GenericDao;
import com.library.model.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 *
 * @author hirwa
 */

public class OperationForm extends javax.swing.JInternalFrame {

    List<Operations> operationList, searchResults;
    List<Book> bookList;
    List<Client>  clientList;
    Book book = new Book();
    Client client = new Client();
    Operations operations = new Operations();
    GenericDao<Operations> operationDao = new GenericDao(Operations.class);
    GenericDao<Book> bookDao = new GenericDao(Book.class);
    GenericDao<Client> clientDao = new GenericDao(Client.class);
    DefaultTableModel model;
    
    public OperationForm() {
        initComponents();
        getOperationListFromDao();
        getListOfClientsFromDao();
        getListOfBooksFromDao();
        displayOperationsInTable(operationList);
        updateBookNameComboBox();
        updateClientNameComboBox();
    }

    public void getOperationListFromDao() {
        operationList = operationDao.retrieveAll(operations);
    }
    
    public void getListOfBooksFromDao() {
        bookList= bookDao.retrieveAll(book);
    }

    public void getListOfClientsFromDao() {
        clientList= clientDao.retrieveAll(client);
    }
    
    private void displayOperationsInTable(List<Operations> operations) {
        model = (DefaultTableModel) bookTransactionTable.getModel();
        model.setRowCount(0);

        for (Operations anOperation : operationList) {
            model.addRow(new Object[]{
                anOperation.getOperationId(),
                anOperation.getOperationType(),
                anOperation.getClientNames(),
                anOperation.getBookTitle(),
                anOperation.getTransactionDate(),
                anOperation.getReturnDate()
            });
        }
    }
    
    private void updateBookNameComboBox(){
        bookComboBox.removeAllItems();
        
        bookList.forEach((Book book)-> {
            bookComboBox.addItem(book.getTitle());
        });
    }

    private void updateClientNameComboBox(){
        clientComboBox.removeAllItems();
        
        clientList.forEach((Client client)->{
            clientComboBox.addItem(client.getFirstName()+" "+client.getLastName());
        });
    }
    
    private void resetFields(){
        transactionTypeComboBox.setSelectedIndex(0);
        clientComboBox.setSelectedIndex(0);
        bookComboBox.setSelectedIndex(0);
        transactionDateChooser.setDate(null);
        returnDateChooser.setDate(null);
        searchTextField.setText("");
        clientNameRadioButton.setSelected(true);
    }
    
    private void updateBookAvailability() {
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        inputPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        transactionTypeComboBox = new javax.swing.JComboBox<>();
        clientComboBox = new javax.swing.JComboBox<>();
        bookComboBox = new javax.swing.JComboBox<>();
        transactionDateChooser = new com.toedter.calendar.JDateChooser();
        returnDateChooser = new com.toedter.calendar.JDateChooser();
        searchPanel = new javax.swing.JPanel();
        refreshButtonOperations = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        clientNameRadioButton = new javax.swing.JRadioButton();
        bookRadioButton = new javax.swing.JRadioButton();
        bookCategoryRadioButton = new javax.swing.JRadioButton();
        clientIdRadioButton = new javax.swing.JRadioButton();
        dateRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        presentationPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTransactionTable = new javax.swing.JTable();
        commandPanel1 = new javax.swing.JPanel();
        saveButtonBook = new javax.swing.JButton();
        updateButtonBook = new javax.swing.JButton();
        resetButtonBook = new javax.swing.JButton();
        deleteButtonBook = new javax.swing.JButton();
        exportPdfButton = new javax.swing.JButton();
        exportExcelButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Operations");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        TitleLabel.setText("OPERATIONS");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 18, -1, -1));

        inputPanel.setBackground(new java.awt.Color(255, 255, 204));
        inputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        inputPanel.setForeground(new java.awt.Color(0, 0, 0));
        inputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Transaction Type");
        inputPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 32, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Client");
        inputPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 67, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Book");
        inputPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 102, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Transaction Date");
        inputPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 138, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Return Date");
        inputPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 164, -1, -1));

        transactionTypeComboBox.setBackground(new java.awt.Color(153, 51, 0));
        transactionTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORROW", "RETURN" }));
        inputPanel.add(transactionTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 28, 153, -1));

        clientComboBox.setBackground(new java.awt.Color(153, 51, 0));
        inputPanel.add(clientComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 63, 153, -1));

        bookComboBox.setBackground(new java.awt.Color(153, 51, 0));
        inputPanel.add(bookComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 98, 153, -1));

        transactionDateChooser.setBackground(new java.awt.Color(255, 255, 204));
        inputPanel.add(transactionDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 133, 153, -1));

        returnDateChooser.setBackground(new java.awt.Color(255, 255, 204));
        inputPanel.add(returnDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 164, 153, -1));

        jPanel1.add(inputPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, 330, 200));

        searchPanel.setBackground(new java.awt.Color(255, 255, 204));
        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        searchPanel.setForeground(new java.awt.Color(0, 0, 0));
        searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refreshButtonOperations.setBackground(new java.awt.Color(0, 0, 0));
        refreshButtonOperations.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        refreshButtonOperations.setForeground(new java.awt.Color(255, 255, 255));
        refreshButtonOperations.setText("REFRESH");
        refreshButtonOperations.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshButtonOperations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonOperationsActionPerformed(evt);
            }
        });
        searchPanel.add(refreshButtonOperations, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 126, 33));

        searchTextField.setBackground(new java.awt.Color(153, 51, 0));
        searchTextField.setForeground(new java.awt.Color(255, 255, 255));
        searchPanel.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 45, 188, 24));

        searchButton.setBackground(new java.awt.Color(0, 0, 0));
        searchButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("SEARCH");
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchPanel.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 41, 126, 33));

        clientNameRadioButton.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(clientNameRadioButton);
        clientNameRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        clientNameRadioButton.setSelected(true);
        clientNameRadioButton.setText("Client Name");
        clientNameRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientNameRadioButtonActionPerformed(evt);
            }
        });
        searchPanel.add(clientNameRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        bookRadioButton.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(bookRadioButton);
        bookRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        bookRadioButton.setText("Book");
        searchPanel.add(bookRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        bookCategoryRadioButton.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(bookCategoryRadioButton);
        bookCategoryRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        bookCategoryRadioButton.setText("Book Category");
        searchPanel.add(bookCategoryRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        clientIdRadioButton.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(clientIdRadioButton);
        clientIdRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        clientIdRadioButton.setText("Client Id");
        searchPanel.add(clientIdRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        dateRadioButton.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(dateRadioButton);
        dateRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        dateRadioButton.setText("Date");
        searchPanel.add(dateRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("By");
        searchPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jPanel1.add(searchPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 61, 590, 111));

        presentationPanel.setBackground(new java.awt.Color(255, 255, 204));
        presentationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        presentationPanel.setForeground(new java.awt.Color(0, 0, 0));
        presentationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bookTransactionTable.setBackground(new java.awt.Color(0, 0, 0));
        bookTransactionTable.setForeground(new java.awt.Color(255, 255, 255));
        bookTransactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Operation Number", "Transaction Type ", "Client", "Book", "Transaction Date", "Return Date"
            }
        ));
        bookTransactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookTransactionTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bookTransactionTable);

        presentationPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 16, 581, 236));

        jPanel1.add(presentationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 178, 590, 270));

        commandPanel1.setBackground(new java.awt.Color(255, 255, 204));
        commandPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        commandPanel1.setForeground(new java.awt.Color(0, 0, 0));
        commandPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saveButtonBook.setBackground(new java.awt.Color(0, 102, 51));
        saveButtonBook.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        saveButtonBook.setForeground(new java.awt.Color(255, 255, 255));
        saveButtonBook.setText("SAVE");
        saveButtonBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButtonBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonBookActionPerformed(evt);
            }
        });
        commandPanel1.add(saveButtonBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 35, 110, 33));

        updateButtonBook.setBackground(new java.awt.Color(204, 153, 0));
        updateButtonBook.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        updateButtonBook.setForeground(new java.awt.Color(255, 255, 255));
        updateButtonBook.setText("UPDATE");
        updateButtonBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButtonBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonBookActionPerformed(evt);
            }
        });
        commandPanel1.add(updateButtonBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 35, 125, 33));

        resetButtonBook.setBackground(new java.awt.Color(255, 204, 102));
        resetButtonBook.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        resetButtonBook.setForeground(new java.awt.Color(255, 255, 255));
        resetButtonBook.setText("RESET");
        resetButtonBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetButtonBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonBookActionPerformed(evt);
            }
        });
        commandPanel1.add(resetButtonBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 79, 110, 33));

        deleteButtonBook.setBackground(new java.awt.Color(153, 0, 0));
        deleteButtonBook.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        deleteButtonBook.setForeground(new java.awt.Color(255, 255, 255));
        deleteButtonBook.setText("DELETE");
        deleteButtonBook.setToolTipText("");
        deleteButtonBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButtonBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonBookActionPerformed(evt);
            }
        });
        commandPanel1.add(deleteButtonBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 79, 125, 33));

        exportPdfButton.setBackground(new java.awt.Color(255, 0, 0));
        exportPdfButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        exportPdfButton.setForeground(new java.awt.Color(255, 255, 255));
        exportPdfButton.setText("Export PDF");
        exportPdfButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportPdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportPdfButtonActionPerformed(evt);
            }
        });
        commandPanel1.add(exportPdfButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 123, -1, 33));

        exportExcelButton.setBackground(new java.awt.Color(0, 153, 0));
        exportExcelButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        exportExcelButton.setForeground(new java.awt.Color(255, 255, 255));
        exportExcelButton.setText("Export EXCEL");
        exportExcelButton.setToolTipText("");
        exportExcelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportExcelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelButtonActionPerformed(evt);
            }
        });
        commandPanel1.add(exportExcelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 123, -1, 33));

        jPanel1.add(commandPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 259, 329, 190));

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

    private void saveButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonBookActionPerformed
        String operationType = transactionTypeComboBox.getSelectedItem().toString();
        String clientNames = clientComboBox.getSelectedItem().toString();
        String bookTitle = bookComboBox.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transactionDate = dateFormat.format(transactionDateChooser.getDate());
        String returnDate = dateFormat.format(returnDateChooser.getDate());
        
        operations.setOperationType(operationType);
        operations.setClientNames(clientNames);
        operations.setBookTitle(bookTitle);
        operations.setTransactionDate(transactionDate);
        operations.setReturnDate(returnDate);
        
        operationDao.save(operations);
        
        getOperationListFromDao();
        displayOperationsInTable(operationList);
        resetFields();
        updateBookAvailability();
        JOptionPane.showMessageDialog(this, "Operation Saved", "Success", JOptionPane.INFORMATION_MESSAGE);                
    }//GEN-LAST:event_saveButtonBookActionPerformed

    private void updateButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonBookActionPerformed
        String operationType = transactionTypeComboBox.getSelectedItem().toString();
        String clientNames = clientComboBox.getSelectedItem().toString();
        String bookTitle = bookComboBox.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transactionDate = dateFormat.format(transactionDateChooser.getDate());
        String returnDate = dateFormat.format(returnDateChooser.getDate());
        
        operations.setOperationType(operationType);
        operations.setClientNames(clientNames);
        operations.setBookTitle(bookTitle);
        operations.setTransactionDate(transactionDate);
        operations.setReturnDate(returnDate);
        
        operationDao.update(operations);

        getOperationListFromDao();
        displayOperationsInTable(operationList);
        updateBookAvailability();
        resetFields();
        JOptionPane.showMessageDialog(this, "Operation Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_updateButtonBookActionPerformed

    private void deleteButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonBookActionPerformed
        String operationType = transactionTypeComboBox.getSelectedItem().toString();
        String clientNames = clientComboBox.getSelectedItem().toString();
        String bookTitle = bookComboBox.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transactionDate = dateFormat.format(transactionDateChooser.getDate());
        String returnDate = dateFormat.format(returnDateChooser.getDate());
        
        operations.setOperationType(operationType);
        operations.setClientNames(clientNames);
        operations.setBookTitle(bookTitle);
        operations.setTransactionDate(transactionDate);
        operations.setReturnDate(returnDate);
        
        operationDao.delete(operations);

        getOperationListFromDao();
        displayOperationsInTable(operationList);
        updateBookAvailability();
        resetFields();
        JOptionPane.showMessageDialog(this, "Operation Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);        
        
    }//GEN-LAST:event_deleteButtonBookActionPerformed

    private void resetButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonBookActionPerformed
        resetFields();
    }//GEN-LAST:event_resetButtonBookActionPerformed

    private void bookTransactionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookTransactionTableMouseClicked
        try {
            model = (DefaultTableModel) bookTransactionTable.getModel();
            int selectedRow = bookTransactionTable.getSelectedRow();
            
            transactionTypeComboBox.setSelectedItem(model.getValueAt(selectedRow, 1));
            clientComboBox.setSelectedItem(model.getValueAt(selectedRow, 2));
            bookComboBox.setSelectedItem(model.getValueAt(selectedRow, 3));
            java.util.Date transactionDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRow, 4).toString());
            transactionDateChooser.setDate(transactionDate);
            java.util.Date returnDate = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(selectedRow, 5).toString());
            returnDateChooser.setDate(returnDate);
            
        } catch (ParseException ex) {
            Logger.getLogger(OperationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bookTransactionTableMouseClicked

    private void refreshButtonOperationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonOperationsActionPerformed
        getOperationListFromDao();
        displayOperationsInTable(operationList);
    }//GEN-LAST:event_refreshButtonOperationsActionPerformed

    private void exportPdfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPdfButtonActionPerformed
        try {
            String path = "/home/hirwa/Downloads/Documents/";
            JFileChooser pdfFile = new JFileChooser();
            pdfFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int x = pdfFile.showSaveDialog(this);
            if (x == JFileChooser.APPROVE_OPTION) {
                path = pdfFile.getSelectedFile().getPath();
            }
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path + "StudentReport.pdf"));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(6);
            pdfTable.addCell("Operation Id");
            pdfTable.addCell("Operation Type");
            pdfTable.addCell("Client Title");
            pdfTable.addCell("Book Title");
            pdfTable.addCell("Transaction Date");
            pdfTable.addCell("Return Date");
            
            for (int i=0; i< bookTransactionTable.getRowCount(); i++){
                String operationNumber = bookTransactionTable.getValueAt(i, 0).toString();
                String transactionType = bookTransactionTable.getValueAt(i, 1).toString();
                String clientName = bookTransactionTable.getValueAt(i, 2).toString();
                String bookName = bookTransactionTable.getValueAt(i, 3).toString();
                String transactionDate = bookTransactionTable.getValueAt(i, 4).toString();
                String returnDate = bookTransactionTable.getValueAt(i, 5).toString();

                pdfTable.addCell(operationNumber);
                pdfTable.addCell(transactionType);
                pdfTable.addCell(clientName);
                pdfTable.addCell(bookName);
                pdfTable.addCell(transactionDate);
                pdfTable.addCell(returnDate);
            }
            
            doc.add(pdfTable);
            JOptionPane.showMessageDialog(this, "Successfuly exported Pdf Report!!");    
            doc.close();
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(OperationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_exportPdfButtonActionPerformed

    private void exportExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelButtonActionPerformed
        FileOutputStream out = null;
        try {
            try (HSSFWorkbook workbook = new HSSFWorkbook()) {
                HSSFSheet sheet = workbook.createSheet("Main");
                
                Row heading = sheet.createRow(0);
                heading.createCell(0).setCellValue("Operation Id");
                heading.createCell(1).setCellValue("Operation Type ");
                heading.createCell(2).setCellValue("Client Names");
                heading.createCell(3).setCellValue("Book Title");
                heading.createCell(4).setCellValue("Transaction Date");
                heading.createCell(5).setCellValue("Return Date");
                
                
                for (int i=0;i<=5;i++){
                    CellStyle style = workbook.createCellStyle();
                    HSSFFont font = workbook.createFont();
                    font.setBold(true);
                    font.setFontName(HSSFFont.FONT_ARIAL);
                    
                    style.setFont(font);
                    style.setVerticalAlignment(VerticalAlignment.CENTER);
                    heading.getCell(i).setCellStyle(style);
                }
                
                int numberOfRow=1;
                
                for (Operations anOperation: operationDao.retrieveAll(operations)){
                    Row row = sheet.createRow(numberOfRow);
                    
                    Cell fname = row.createCell(0);
                    fname.setCellValue(anOperation.getOperationId());
                    
                    Cell lname = row.createCell(1);
                    lname.setCellValue(anOperation.getOperationType());
                    
                    Cell regno = row.createCell(2);
                    regno.setCellValue(anOperation.getClientNames());
                    
                    Cell email = row.createCell(3);
                    email.setCellValue(anOperation.getBookTitle());
                    
                    Cell faculty = row.createCell(4);
                    faculty.setCellValue(anOperation.getTransactionDate());
                    
                    Cell phone = row.createCell(5);
                    phone.setCellValue(anOperation.getReturnDate());
                    
                    numberOfRow++;
                }
                
                for (int i=0; i<=5; i++){
                    sheet.autoSizeColumn(i);
                }
                
                out = new FileOutputStream(new File("/home/hirwa/Downloads/Documents/Transaction.xlsx"));
                workbook.write(out);
                out.close();
            }
            System.out.println("Data Writen successfully!");
            
            JOptionPane.showMessageDialog(this, "Excel export Successful!","Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException ex) {
            Logger.getLogger(OperationForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Can't Export the file.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(OperationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_exportExcelButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if ("".equals(searchTextField.getText())) {
            JOptionPane.showMessageDialog(this, "Nothing to search!","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            //Searching according to the selected Radio button
            if(clientNameRadioButton.isSelected()){
                String searchedItem = searchTextField.getText(); 
                searchResults = operationDao.searchClientName(searchedItem, operations);            
            }else if(clientIdRadioButton.isSelected()){
                String searchedItem = searchTextField.getText(); 
                operationDao.FindClientId(searchedItem, client);
                searchResults = operationDao.searchClientId(operations);            
            }else if(bookRadioButton.isSelected()){
                String searchedItem = searchTextField.getText();     
                searchResults = operationDao.searchBook(searchedItem, operations);            
            }else if(bookCategoryRadioButton.isSelected()){
                String searchedItem = searchTextField.getText(); 
                searchResults = operationDao.searchBookCategory(searchedItem, operations);            
            }else if(dateRadioButton.isSelected()){
                String searchedItem = searchTextField.getText(); 
                searchResults = operationDao.searchDate(searchedItem, operations);            
            }
             
            //DISPLAYING RESULTS ACCORDING TO WHAT IS RETURNED
            if (searchResults.isEmpty()) {
                //Displaying results in the table
                model = (DefaultTableModel) bookTransactionTable.getModel();
                model.setRowCount(0);

                for (Operations results : searchResults) {
                    model.addRow(new Object[]{
                        results.getOperationId(),
                        results.getOperationType(),
                        results.getClientNames(),
                        results.getBookTitle(),
                        results.getTransactionDate(),
                        results.getReturnDate()
                    });
                }
                resetFields();
                JOptionPane.showMessageDialog(this, " No result found!!","Result",JOptionPane.ERROR_MESSAGE);
            } else {
                //Displaying results in the table
                model = (DefaultTableModel) bookTransactionTable.getModel();
                model.setRowCount(0);

                for (Operations results : searchResults) {
                    model.addRow(new Object[]{
                        results.getOperationId(),
                        results.getOperationType(),
                        results.getClientNames(),
                        results.getBookTitle(),
                        results.getTransactionDate(),
                        results.getReturnDate()
                    });
                }
                //Reseting inputs
                resetFields();
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void clientNameRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientNameRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientNameRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JRadioButton bookCategoryRadioButton;
    private javax.swing.JComboBox<String> bookComboBox;
    private javax.swing.JRadioButton bookRadioButton;
    private javax.swing.JTable bookTransactionTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> clientComboBox;
    private javax.swing.JRadioButton clientIdRadioButton;
    private javax.swing.JRadioButton clientNameRadioButton;
    private javax.swing.JPanel commandPanel1;
    private javax.swing.JRadioButton dateRadioButton;
    private javax.swing.JButton deleteButtonBook;
    private javax.swing.JButton exportExcelButton;
    private javax.swing.JButton exportPdfButton;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel presentationPanel;
    private javax.swing.JButton refreshButtonOperations;
    private javax.swing.JButton resetButtonBook;
    private com.toedter.calendar.JDateChooser returnDateChooser;
    private javax.swing.JButton saveButtonBook;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private com.toedter.calendar.JDateChooser transactionDateChooser;
    private javax.swing.JComboBox<String> transactionTypeComboBox;
    private javax.swing.JButton updateButtonBook;
    // End of variables declaration//GEN-END:variables
}
