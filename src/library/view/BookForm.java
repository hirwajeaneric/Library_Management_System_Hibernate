package library.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import library.controller.GenericDao;
import library.model.Book;
import library.model.BookCategory;

/**
 *
 * @author hirwa
 */
public class BookForm extends javax.swing.JInternalFrame {

    //Variables and instances
    
    List<Book> bookList;  
    List<BookCategory> bookCategoryList;  
    
    Book book = new Book();
    BookCategory bookCategory = new BookCategory();
    
    GenericDao<Book> bookActions = new GenericDao(Book.class);
    GenericDao<BookCategory> bookCategoryActions = new GenericDao(BookCategory.class);
    
    DefaultTableModel model1;
    DefaultTableModel model2;

    
    //Constructor
    
    public BookForm() {
        initComponents();
        retrieveBookList();
        retrieveBookCategoryList();
        displayBooksInTable();
        displayBookCategoriesInTable();
        updateBookCategoryComboBox();
    }

    //My additional Methods
    
    public void retrieveBookList() {
        bookList = bookActions.retrieveAll(book);
    }
    
    public void retrieveBookCategoryList() {
        bookCategoryList = bookCategoryActions.retrieveAll(bookCategory);
    }
    
    private void displayBooksInTable() {
        model1 = (DefaultTableModel) BookTable.getModel();
        model1.setRowCount(0);

        for (Book aBook : bookList) {
            model1.addRow(new Object[]{
                aBook.getBookId(),
                aBook.getTitle(),
                aBook.getAuthor(),
                aBook.getBookCategory(),
                aBook.getPublishingHouse(),
                aBook.getPublicationDate(),
                aBook.getPages(),
                aBook.getAvailable()
            });
        }
    }
    
    private void displayBookCategoriesInTable(){
        model2 = (DefaultTableModel) BookCategoryTable.getModel();
        model2.setRowCount(0);
        
        for (BookCategory aCategry : bookCategoryList) {
            model2.addRow(new Object[]{
                aCategry.getCategoryCode(),
                aCategry.getCategoryName()
            });
        }
    }
    
    public void resetBookTabFields() {
        bookIdTextField.setText("");
        titleTextField.setText("");
        authorTextField.setText("");
        bookCategoryComboBox.setSelectedIndex(0);
        publicationHouseTextField.setText("");
        publicationDateChooser.setDate(null);
        pagesTextField.setText("");
        availableComboBox.setSelectedIndex(0);
    }
    
    public void resetBookCategoryFields(){
        CategoryCodeTextField.setText("");
        categoryNameTextField.setText("");
    }
    
    public void updateBookCategoryComboBox(){
        bookCategoryComboBox.removeAllItems();

        bookCategoryList.forEach((BookCategory bct)->{
            bookCategoryComboBox.addItem(bct.getCategoryName());
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        inputPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bookIdTextField = new javax.swing.JTextField();
        titleTextField = new javax.swing.JTextField();
        authorTextField = new javax.swing.JTextField();
        publicationHouseTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        availableComboBox = new javax.swing.JComboBox<>();
        publicationDateChooser = new com.toedter.calendar.JDateChooser();
        pagesTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bookCategoryComboBox = new javax.swing.JComboBox<>();
        commandPanel = new javax.swing.JPanel();
        saveButtonBook = new javax.swing.JButton();
        updateButtonBook = new javax.swing.JButton();
        resetButtonBook = new javax.swing.JButton();
        deleteButtonBook = new javax.swing.JButton();
        presentationPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BookTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        inputPanel1 = new javax.swing.JPanel();
        CategoryCode = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CategoryCodeTextField = new javax.swing.JTextField();
        categoryNameTextField = new javax.swing.JTextField();
        commandPanel1 = new javax.swing.JPanel();
        saveButtonBookCategory = new javax.swing.JButton();
        updateButtonBookCategory = new javax.swing.JButton();
        resetButtonBookCategory = new javax.swing.JButton();
        deleteButtonBookCategory = new javax.swing.JButton();
        presentationPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BookCategoryTable = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Books");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        TitleLabel.setFont(new java.awt.Font("URW Chancery L", 1, 24)); // NOI18N
        TitleLabel.setText("BOOKS");

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        inputPanel.setBackground(new java.awt.Color(255, 255, 204));
        inputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        inputPanel.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Book Id");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Title");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Author");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Publishing House");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Publication Date");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Pages");

        bookIdTextField.setBackground(new java.awt.Color(102, 51, 0));
        bookIdTextField.setForeground(new java.awt.Color(255, 255, 255));

        titleTextField.setBackground(new java.awt.Color(102, 51, 0));
        titleTextField.setForeground(new java.awt.Color(255, 255, 255));

        authorTextField.setBackground(new java.awt.Color(102, 51, 0));
        authorTextField.setForeground(new java.awt.Color(255, 255, 255));

        publicationHouseTextField.setBackground(new java.awt.Color(102, 51, 0));
        publicationHouseTextField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Available");

        availableComboBox.setBackground(new java.awt.Color(102, 51, 0));
        availableComboBox.setForeground(new java.awt.Color(255, 255, 255));
        availableComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        publicationDateChooser.setBackground(new java.awt.Color(255, 255, 204));

        pagesTextField.setBackground(new java.awt.Color(102, 51, 0));
        pagesTextField.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Book Category");

        bookCategoryComboBox.setBackground(new java.awt.Color(102, 51, 0));
        bookCategoryComboBox.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(availableComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookIdTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookCategoryComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pagesTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publicationHouseTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(publicationDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(bookIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(publicationHouseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addComponent(publicationDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pagesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12)
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(availableComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(6, 6, 6))
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        commandPanel.setBackground(new java.awt.Color(255, 255, 204));
        commandPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        commandPanel.setForeground(new java.awt.Color(0, 0, 0));

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

        javax.swing.GroupLayout commandPanelLayout = new javax.swing.GroupLayout(commandPanel);
        commandPanel.setLayout(commandPanelLayout);
        commandPanelLayout.setHorizontalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetButtonBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButtonBook, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(commandPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(updateButtonBook, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(deleteButtonBook, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        commandPanelLayout.setVerticalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(updateButtonBook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButtonBook, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetButtonBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButtonBook, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        presentationPanel.setBackground(new java.awt.Color(255, 255, 204));
        presentationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        presentationPanel.setForeground(new java.awt.Color(0, 0, 0));

        BookTable.setBackground(new java.awt.Color(0, 0, 0));
        BookTable.setForeground(new java.awt.Color(255, 255, 255));
        BookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Title", "Author", "Book Category", "Publishing House", "Publication Date", "Pages", "Available"
            }
        ));
        BookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BookTable);

        javax.swing.GroupLayout presentationPanelLayout = new javax.swing.GroupLayout(presentationPanel);
        presentationPanel.setLayout(presentationPanelLayout);
        presentationPanelLayout.setHorizontalGroup(
            presentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );
        presentationPanelLayout.setVerticalGroup(
            presentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(presentationPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(commandPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(presentationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(presentationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("BOOK", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));

        inputPanel1.setBackground(new java.awt.Color(255, 255, 204));
        inputPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inputs"));

        CategoryCode.setForeground(new java.awt.Color(0, 0, 0));
        CategoryCode.setText("Category Code");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Category Name");

        CategoryCodeTextField.setBackground(new java.awt.Color(102, 51, 0));
        CategoryCodeTextField.setForeground(new java.awt.Color(255, 255, 255));

        categoryNameTextField.setBackground(new java.awt.Color(102, 51, 0));
        categoryNameTextField.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout inputPanel1Layout = new javax.swing.GroupLayout(inputPanel1);
        inputPanel1.setLayout(inputPanel1Layout);
        inputPanel1Layout.setHorizontalGroup(
            inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(CategoryCode, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CategoryCodeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(categoryNameTextField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputPanel1Layout.setVerticalGroup(
            inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputPanel1Layout.createSequentialGroup()
                        .addGroup(inputPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CategoryCode)
                            .addComponent(CategoryCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addComponent(categoryNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        commandPanel1.setBackground(new java.awt.Color(255, 255, 204));
        commandPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Commands"));

        saveButtonBookCategory.setBackground(new java.awt.Color(0, 102, 51));
        saveButtonBookCategory.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        saveButtonBookCategory.setForeground(new java.awt.Color(255, 255, 255));
        saveButtonBookCategory.setText("SAVE");
        saveButtonBookCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonBookCategoryActionPerformed(evt);
            }
        });

        updateButtonBookCategory.setBackground(new java.awt.Color(204, 153, 0));
        updateButtonBookCategory.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        updateButtonBookCategory.setForeground(new java.awt.Color(255, 255, 255));
        updateButtonBookCategory.setText("UPDATE");
        updateButtonBookCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonBookCategoryActionPerformed(evt);
            }
        });

        resetButtonBookCategory.setBackground(new java.awt.Color(255, 204, 102));
        resetButtonBookCategory.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        resetButtonBookCategory.setForeground(new java.awt.Color(255, 255, 255));
        resetButtonBookCategory.setText("RESET");
        resetButtonBookCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonBookCategoryActionPerformed(evt);
            }
        });

        deleteButtonBookCategory.setBackground(new java.awt.Color(153, 0, 0));
        deleteButtonBookCategory.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        deleteButtonBookCategory.setForeground(new java.awt.Color(255, 255, 255));
        deleteButtonBookCategory.setText("DELETE");
        deleteButtonBookCategory.setToolTipText("");
        deleteButtonBookCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonBookCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout commandPanel1Layout = new javax.swing.GroupLayout(commandPanel1);
        commandPanel1.setLayout(commandPanel1Layout);
        commandPanel1Layout.setHorizontalGroup(
            commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetButtonBookCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButtonBookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(commandPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(updateButtonBookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commandPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(deleteButtonBookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        commandPanel1Layout.setVerticalGroup(
            commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanel1Layout.createSequentialGroup()
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(updateButtonBookCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButtonBookCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(commandPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(resetButtonBookCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButtonBookCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        presentationPanel1.setBackground(new java.awt.Color(255, 255, 204));
        presentationPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Presentation"));

        BookCategoryTable.setBackground(new java.awt.Color(0, 0, 0));
        BookCategoryTable.setForeground(new java.awt.Color(255, 255, 255));
        BookCategoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Id", "Category Name"
            }
        ));
        BookCategoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookCategoryTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(BookCategoryTable);

        javax.swing.GroupLayout presentationPanel1Layout = new javax.swing.GroupLayout(presentationPanel1);
        presentationPanel1.setLayout(presentationPanel1Layout);
        presentationPanel1Layout.setHorizontalGroup(
            presentationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        presentationPanel1Layout.setVerticalGroup(
            presentationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(presentationPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(presentationPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(inputPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commandPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(commandPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(presentationPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BOOK CATEGORY", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
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
        String bookId = bookIdTextField.getText();
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String bookCategory = bookCategoryComboBox.getSelectedItem().toString();
        String publishingHouse = publicationHouseTextField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String publicationDate = dateFormat.format(publicationDateChooser.getDate());
        int pages = Integer.parseInt(pagesTextField.getText());
        String available = availableComboBox.getSelectedItem().toString();
        
        book = new Book(bookId, title, author, bookCategory, publishingHouse, publicationDate, pages, available);
        
        bookActions.save(book);
        
        retrieveBookList();
        displayBooksInTable();
        resetBookTabFields();
        JOptionPane.showMessageDialog(this, "Book Saved", "Success", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_saveButtonBookActionPerformed

    private void updateButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonBookActionPerformed
        String bookId = bookIdTextField.getText();
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String bookCategory = bookCategoryComboBox.getSelectedItem().toString();
        String publishingHouse = publicationHouseTextField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String publicationDate = dateFormat.format(publicationDateChooser.getDate());
        int pages = Integer.parseInt(pagesTextField.getText());
        String available = availableComboBox.getSelectedItem().toString();
        
        book = new Book(bookId, title, author, bookCategory, publishingHouse, publicationDate, pages, available);
        
        bookActions.update(book);
        
        retrieveBookList();
        displayBooksInTable();
        resetBookTabFields();
        JOptionPane.showMessageDialog(this, "Book Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_updateButtonBookActionPerformed

    private void deleteButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonBookActionPerformed
        String bookId = bookIdTextField.getText();
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String bookCategory = bookCategoryComboBox.getSelectedItem().toString();
        String publishingHouse = publicationHouseTextField.getText();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String publicationDate = dateFormat.format(publicationDateChooser.getDate());
        int pages = Integer.parseInt(pagesTextField.getText());
        String available = availableComboBox.getSelectedItem().toString();
        
        book = new Book(bookId, title, author, bookCategory, publishingHouse, publicationDate, pages, available);
        
        bookActions.delete(book);
        
        retrieveBookList();
        displayBooksInTable();
        resetBookTabFields();
        JOptionPane.showMessageDialog(this, "Book Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
        
            }//GEN-LAST:event_deleteButtonBookActionPerformed

    private void resetButtonBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonBookActionPerformed
        resetBookTabFields();
    }//GEN-LAST:event_resetButtonBookActionPerformed

    private void saveButtonBookCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonBookCategoryActionPerformed
        String bookCategoryCode = CategoryCodeTextField.getText();
        String bookCategoryName = categoryNameTextField.getText();
        
        bookCategory = new BookCategory(bookCategoryCode, bookCategoryName);
        
        bookCategoryActions.save(bookCategory);
        
        retrieveBookCategoryList();
        displayBookCategoriesInTable();
        resetBookCategoryFields();
        
        JOptionPane.showMessageDialog(this, "Category Saved", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        updateBookCategoryComboBox();
    }//GEN-LAST:event_saveButtonBookCategoryActionPerformed

    private void updateButtonBookCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonBookCategoryActionPerformed
        String bookCategoryCode = CategoryCodeTextField.getText();
        String bookCategoryName = categoryNameTextField.getText();
        
        bookCategory = new BookCategory(bookCategoryCode, bookCategoryName);
        
        bookCategoryActions.update(bookCategory);
        
        retrieveBookCategoryList();
        displayBookCategoriesInTable();
        resetBookCategoryFields();
        
        JOptionPane.showMessageDialog(this, "Category Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        updateBookCategoryComboBox();
    }//GEN-LAST:event_updateButtonBookCategoryActionPerformed

    private void deleteButtonBookCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonBookCategoryActionPerformed
        String bookCategoryCode = CategoryCodeTextField.getText();
        String bookCategoryName = categoryNameTextField.getText();
        
        bookCategory = new BookCategory(bookCategoryCode, bookCategoryName);
        
        bookCategoryActions.delete(bookCategory);
        
        retrieveBookCategoryList();
        displayBookCategoriesInTable();
        resetBookCategoryFields();
       
        JOptionPane.showMessageDialog(this, "Category Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        updateBookCategoryComboBox();
    }//GEN-LAST:event_deleteButtonBookCategoryActionPerformed

    private void resetButtonBookCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonBookCategoryActionPerformed
        resetBookCategoryFields();
    }//GEN-LAST:event_resetButtonBookCategoryActionPerformed

    private void BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookTableMouseClicked
        try {
            model1 = (DefaultTableModel) BookTable.getModel();
            int selectedRow1 = BookTable.getSelectedRow();
            
            bookIdTextField.setText(model1.getValueAt(selectedRow1, 0).toString());
            titleTextField.setText(model1.getValueAt(selectedRow1, 1).toString());
            authorTextField.setText(model1.getValueAt(selectedRow1, 2).toString());
            bookCategoryComboBox.setSelectedItem(model1.getValueAt(selectedRow1, 3).toString());
            publicationHouseTextField.setText(model1.getValueAt(selectedRow1, 4).toString());
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model1.getValueAt(selectedRow1, 5).toString());
            publicationDateChooser.setDate(date);
            pagesTextField.setText(model1.getValueAt(selectedRow1, 6).toString());
            availableComboBox.setSelectedItem(model1.getValueAt(selectedRow1, 7).toString());
        
        } catch (ParseException ex) {
            Logger.getLogger(BookForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_BookTableMouseClicked

    private void BookCategoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookCategoryTableMouseClicked
        model2 = (DefaultTableModel) BookCategoryTable.getModel();
        int selectedRow2 = BookCategoryTable.getSelectedRow();
        
        CategoryCodeTextField.setText(model2.getValueAt(selectedRow2, 0).toString());
        categoryNameTextField.setText(model2.getValueAt(selectedRow2, 1).toString());
        
    }//GEN-LAST:event_BookCategoryTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BookCategoryTable;
    private javax.swing.JTable BookTable;
    private javax.swing.JLabel CategoryCode;
    private javax.swing.JTextField CategoryCodeTextField;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JComboBox<String> availableComboBox;
    private javax.swing.JComboBox<String> bookCategoryComboBox;
    private javax.swing.JTextField bookIdTextField;
    private javax.swing.JTextField categoryNameTextField;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JPanel commandPanel1;
    private javax.swing.JButton deleteButtonBook;
    private javax.swing.JButton deleteButtonBookCategory;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JPanel inputPanel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField pagesTextField;
    private javax.swing.JPanel presentationPanel;
    private javax.swing.JPanel presentationPanel1;
    private com.toedter.calendar.JDateChooser publicationDateChooser;
    private javax.swing.JTextField publicationHouseTextField;
    private javax.swing.JButton resetButtonBook;
    private javax.swing.JButton resetButtonBookCategory;
    private javax.swing.JButton saveButtonBook;
    private javax.swing.JButton saveButtonBookCategory;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JButton updateButtonBook;
    private javax.swing.JButton updateButtonBookCategory;
    // End of variables declaration//GEN-END:variables
}
