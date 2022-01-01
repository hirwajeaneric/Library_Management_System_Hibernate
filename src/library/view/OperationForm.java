package library.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import library.controller.GenericDao;
import library.model.Book;
import library.model.Client;
import library.model.Operations;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 *
 * @author hirwa
 */
public class OperationForm extends javax.swing.JInternalFrame {

    List<Operations> operationList;
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
        retrieveOperationList();
        retrieveListOfClients();
        retrieveListOfBooks();
        displayOperationsInTable(operationList);
        updateBookNameComboBox();
        updateClientNameComboBox();
    }

    public void retrieveOperationList() {
        operationList = operationDao.retrieveAll(operations);
    }
    
    public void retrieveListOfBooks() {
        bookList= bookDao.retrieveAll(book);
    }

    public void retrieveListOfClients() {
        clientList= clientDao.retrieveAll(client);
    }
    
    public void displayOperationsInTable(List<Operations> transactions) {
        model = (DefaultTableModel) bookTransactionTable.getModel();
        model.setRowCount(0);

        for (Operations anOperation : operationList) {
            model.addRow(new Object[]{
                anOperation.getOperationNumber(),
                anOperation.getTransactionType(),
                anOperation.getClient(),
                anOperation.getBook(),
                anOperation.getTransactionDate(),
                anOperation.getReturnDate()
            });
        }
    }
    
    public void updateBookNameComboBox(){
        bookComboBox.removeAllItems();
        
        bookList.forEach((Book bk)->{
            bookComboBox.addItem(bk.getTitle());
        });
    }

    public void updateClientNameComboBox(){
        clientComboBox.removeAllItems();
        
        clientList.forEach((Client cl)->{
            clientComboBox.addItem(cl.getFirstName()+" "+cl.getLastName());
        });
    }
    
    public void resetFields(){
        transactionTypeComboBox.setSelectedIndex(0);
        clientComboBox.setSelectedIndex(0);
        bookComboBox.setSelectedIndex(0);
        transactionDateChooser.setDate(null);
        returnDateChooser.setDate(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        searchButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
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

        TitleLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        TitleLabel.setText("OPERATIONS");

        inputPanel.setBackground(new java.awt.Color(255, 255, 204));
        inputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        inputPanel.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Transaction Type");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Client");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Book");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Transaction Date");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Return Date");

        transactionTypeComboBox.setBackground(new java.awt.Color(153, 51, 0));
        transactionTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BORROW", "RETURN" }));

        clientComboBox.setBackground(new java.awt.Color(153, 51, 0));

        bookComboBox.setBackground(new java.awt.Color(153, 51, 0));

        transactionDateChooser.setBackground(new java.awt.Color(255, 255, 204));

        returnDateChooser.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(transactionTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transactionDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(returnDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(transactionTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(bookComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(transactionDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(returnDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchPanel.setBackground(new java.awt.Color(255, 255, 204));
        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        searchPanel.setForeground(new java.awt.Color(0, 0, 0));

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

        searchTextField.setBackground(new java.awt.Color(153, 51, 0));
        searchTextField.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, searchPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(226, 226, 226))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        presentationPanel.setBackground(new java.awt.Color(255, 255, 204));
        presentationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        presentationPanel.setForeground(new java.awt.Color(0, 0, 0));

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

        javax.swing.GroupLayout presentationPanelLayout = new javax.swing.GroupLayout(presentationPanel);
        presentationPanel.setLayout(presentationPanelLayout);
        presentationPanelLayout.setHorizontalGroup(
            presentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
        );
        presentationPanelLayout.setVerticalGroup(
            presentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, presentationPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        commandPanel1.setBackground(new java.awt.Color(255, 255, 204));
        commandPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        commandPanel1.setForeground(new java.awt.Color(0, 0, 0));

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

        javax.swing.GroupLayout commandPanel1Layout = new javax.swing.GroupLayout(commandPanel1);
        commandPanel1.setLayout(commandPanel1Layout);
        commandPanel1Layout.setHorizontalGroup(
            commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exportPdfButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetButtonBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButtonBook, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateButtonBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportExcelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButtonBook, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        commandPanel1Layout.setVerticalGroup(
            commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(updateButtonBook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButtonBook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetButtonBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButtonBook, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportPdfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportExcelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(commandPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(presentationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TitleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commandPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(presentationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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

    private void saveButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonBookActionPerformed
        String transactionType = transactionTypeComboBox.getSelectedItem().toString();
        String clientNames = clientComboBox.getSelectedItem().toString();
        String bookTitle = bookComboBox.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transactionDate = dateFormat.format(transactionDateChooser.getDate());
        String returnDate = dateFormat.format(returnDateChooser.getDate());
        
        operations.setTransactionType(transactionType);
        operations.setClient(clientNames);
        operations.setBook(bookTitle);
        operations.setTransactionDate(transactionDate);
        operations.setReturnDate(returnDate);
        
        operationDao.save(operations);
        
        retrieveOperationList();
        displayOperationsInTable(operationList);
        resetFields();
        JOptionPane.showMessageDialog(this, "Transaction Saved", "Success", JOptionPane.INFORMATION_MESSAGE);                
    }//GEN-LAST:event_saveButtonBookActionPerformed

    private void updateButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonBookActionPerformed
        String transactionType = transactionTypeComboBox.getSelectedItem().toString();
        String clientNames = clientComboBox.getSelectedItem().toString();
        String bookTitle = bookComboBox.getSelectedItem().toString();        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transactionDate = dateFormat.format(transactionDateChooser.getDate());
        String returnDate = dateFormat.format(returnDateChooser.getDate());
        
        operations.setTransactionType(transactionType);
        operations.setClient(clientNames);
        operations.setBook(bookTitle);
        operations.setTransactionDate(transactionDate);
        operations.setReturnDate(returnDate);
        
        operationDao.update(operations);

        retrieveOperationList();
        displayOperationsInTable(operationList);
        resetFields();
        JOptionPane.showMessageDialog(this, "Transaction Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_updateButtonBookActionPerformed

    private void deleteButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonBookActionPerformed
        String transactionType = transactionTypeComboBox.getSelectedItem().toString();
        String clientNames = clientComboBox.getSelectedItem().toString();
        String bookTitle = bookComboBox.getSelectedItem().toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String transactionDate = dateFormat.format(transactionDateChooser.getDate());
        String returnDate = dateFormat.format(returnDateChooser.getDate());
        
        operations.setTransactionType(transactionType);
        operations.setClient(clientNames);
        operations.setBook(bookTitle);
        operations.setTransactionDate(transactionDate);
        operations.setReturnDate(returnDate);
        
        operationDao.delete(operations);

        retrieveOperationList();
        displayOperationsInTable(operationList);
        resetFields();
        JOptionPane.showMessageDialog(this, "Transaction Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);        
        
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

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        if ("".equals(searchTextField.getText())) {
            JOptionPane.showMessageDialog(this, "Nothing to search!","Error",JOptionPane.ERROR_MESSAGE);
        } else {
            String searchedItem = searchTextField.getText();
            
            List<Operations> searchResults = operationDao.searchData(searchedItem, operations);            
            
            if (searchResults.isEmpty()) {
                displayOperationsInTable(searchResults);
                resetFields();
                JOptionPane.showMessageDialog(this, " No result found!!","Result",JOptionPane.ERROR_MESSAGE);
            } else {
                displayOperationsInTable(searchResults);
                resetFields();
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void exportPdfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportPdfButtonActionPerformed
        try {
            // TODO add your handling code here:
            String path = "/home/hirwa/Downloads/Documents/";
            JFileChooser pdfFile = new JFileChooser();
            pdfFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int x = pdfFile.showSaveDialog(this);
            if (x == JFileChooser.APPROVE_OPTION) {
                path = pdfFile.getSelectedFile().getPath();
            }
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path + "StudentPdfReport.pdf"));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(6);
            //Adding headers
            pdfTable.addCell("Operatoin Number");
            pdfTable.addCell("Transaction Type");
            pdfTable.addCell("Client Name");
            pdfTable.addCell("Book Name");
            pdfTable.addCell("Transaction Date");
            pdfTable.addCell("Return Date");
            
            //Looping the data from JTable to pdf file
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
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperationForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(OperationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_exportPdfButtonActionPerformed

    private void exportExcelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelButtonActionPerformed
        FileOutputStream out = null;
        try {
            // TODO add your handling code here:
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Sample");
            
            //Heading
            Row heading = sheet.createRow(0);
            heading.createCell(0).setCellValue("Operation Number");
            heading.createCell(1).setCellValue("Transaction Type");
            heading.createCell(2).setCellValue("Client Names");
            heading.createCell(3).setCellValue("Book Title");
            heading.createCell(4).setCellValue("Transaction Date");
            heading.createCell(5).setCellValue("Return Date");

            
            //Setting fonts and text alignment
            for (int i=0;i<=5;i++){
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                heading.getCell(i).setCellStyle(style);
            }   

            //Adding data to the table
            int numberOfRow=1;//We are starting on the first row.
            
            for (Operations anOperation: operationDao.retrieveAll(operations)){
                Row row = sheet.createRow(numberOfRow);//Creating data on a row.
                
                Cell fname = row.createCell(0);
                fname.setCellValue(anOperation.getOperationNumber());
                
                Cell lname = row.createCell(1);
                lname.setCellValue(anOperation.getTransactionType());
                
                Cell regno = row.createCell(2);
                regno.setCellValue(anOperation.getClient());
                
                Cell email = row.createCell(3);
                email.setCellValue(anOperation.getBook());
                
                Cell faculty = row.createCell(4);
                faculty.setCellValue(anOperation.getTransactionDate());
                
                Cell phone = row.createCell(5);
                phone.setCellValue(anOperation.getReturnDate());
                
                numberOfRow++;
            }   
            
            for (int i=0; i<=5; i++){
                sheet.autoSizeColumn(i);
            }   
            
            //Creating the file
            out = new FileOutputStream(new File("/home/hirwa/Downloads/Documents/Report.xlsx"));
            workbook.write(out);
            out.close();
            workbook.close();
            System.out.println("Data Writen successfully!");
            
            JOptionPane.showMessageDialog(this, "Successfully printed Excel file!","Student Registration", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperationForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Can't find the file.", "Student Registration", JOptionPane.ERROR_MESSAGE);
            
        } catch (IOException ex) {
            Logger.getLogger(OperationForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Can't Export the file.", "Student Registration", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                out.close();
            } catch (IOException ex) {
                Logger.getLogger(OperationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_exportExcelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JComboBox<String> bookComboBox;
    private javax.swing.JTable bookTransactionTable;
    private javax.swing.JComboBox<String> clientComboBox;
    private javax.swing.JPanel commandPanel1;
    private javax.swing.JButton deleteButtonBook;
    private javax.swing.JButton exportExcelButton;
    private javax.swing.JButton exportPdfButton;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel presentationPanel;
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
