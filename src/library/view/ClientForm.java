package library.view;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import library.controller.GenericDao;
import library.model.Client;
import library.model.ClientType;

public class ClientForm extends javax.swing.JInternalFrame {

    //THIS SECTION CONTAINS GLOBAL VARIABLES. 
    //Variables to be used when dealing with selection of the image.
    int selectedRow;
    byte[] person_image;
    FileInputStream fileinputstream;
    String thePathOfTheImage;
    File theimage, selectedImage;    
    byte[] ImagePhotoFileFromDatabase;
    
    //Additional but necessary variables and instances
    
    List<Client> clientList;
    
    Client client = new Client();
    //ClientType clientType = new ClientType();
    GenericDao<Client> clientDao = new GenericDao(Client.class);
    
    DefaultTableModel model;
    
    public ClientForm() {
        initComponents();
        retrieveClientList();
        displayClientsInTable();
    }
    
    public void retrieveClientList(){
    
    }
    
    private void displayClientsInTable(){
        
    }

    private void resetFields(){
        registrationNumberTextField.setText(null);
        firstNameTextField.setText(null);
        lastNameTextField.setText(null);
        phoneNumberTextField.setText(null);
        emailTextField.setText(null);
        clientComboBox.setSelectedIndex(0);
        imageLabel.setIcon(null);
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
        jLabel7 = new javax.swing.JLabel();
        BrowseImageButton = new javax.swing.JButton();
        registrationNumberTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        phoneNumberTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        clientComboBox = new javax.swing.JComboBox<>();
        imagePanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        imagePathTextField = new javax.swing.JTextField();
        commandPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        presentationPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clients");

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        TitleLabel.setFont(new java.awt.Font("URW Chancery L", 1, 24)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        TitleLabel.setText("CLIENTS");

        inputPanel.setBackground(new java.awt.Color(255, 255, 204));
        inputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        inputPanel.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Registration Number");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("First Name");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Last Name");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Phone Number");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Email");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Client Category");

        BrowseImageButton.setBackground(new java.awt.Color(0, 0, 0));
        BrowseImageButton.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        BrowseImageButton.setForeground(new java.awt.Color(255, 255, 255));
        BrowseImageButton.setText("Browse Image");
        BrowseImageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BrowseImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrowseImageButtonActionPerformed(evt);
            }
        });

        registrationNumberTextField.setBackground(new java.awt.Color(102, 51, 0));
        registrationNumberTextField.setForeground(new java.awt.Color(255, 255, 255));

        firstNameTextField.setBackground(new java.awt.Color(102, 51, 0));
        firstNameTextField.setForeground(new java.awt.Color(255, 255, 255));

        lastNameTextField.setBackground(new java.awt.Color(102, 51, 0));
        lastNameTextField.setForeground(new java.awt.Color(255, 255, 255));

        phoneNumberTextField.setBackground(new java.awt.Color(102, 51, 0));
        phoneNumberTextField.setForeground(new java.awt.Color(255, 255, 255));

        emailTextField.setBackground(new java.awt.Color(102, 51, 0));
        emailTextField.setForeground(new java.awt.Color(255, 255, 255));

        clientComboBox.setBackground(new java.awt.Color(102, 51, 0));
        clientComboBox.setForeground(new java.awt.Color(255, 255, 255));
        clientComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Staff" }));

        imagePanel.setBackground(new java.awt.Color(51, 51, 51));
        imagePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        imagePathTextField.setBackground(new java.awt.Color(102, 51, 0));

        javax.swing.GroupLayout inputPanelLayout = new javax.swing.GroupLayout(inputPanel);
        inputPanel.setLayout(inputPanelLayout);
        inputPanelLayout.setHorizontalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(BrowseImageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addComponent(imagePathTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(registrationNumberTextField)
                    .addComponent(firstNameTextField)
                    .addComponent(lastNameTextField)
                    .addComponent(phoneNumberTextField)
                    .addComponent(emailTextField)
                    .addComponent(clientComboBox, 0, 153, Short.MAX_VALUE)
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        inputPanelLayout.setVerticalGroup(
            inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(inputPanelLayout.createSequentialGroup()
                                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(inputPanelLayout.createSequentialGroup()
                                        .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(registrationNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(clientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(inputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPanelLayout.createSequentialGroup()
                        .addComponent(BrowseImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imagePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        commandPanel.setBackground(new java.awt.Color(255, 255, 204));
        commandPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        commandPanel.setForeground(new java.awt.Color(0, 0, 0));

        saveButton.setBackground(new java.awt.Color(0, 102, 51));
        saveButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("SAVE");
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(204, 153, 0));
        updateButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("UPDATE");
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        resetButton.setBackground(new java.awt.Color(255, 204, 102));
        resetButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        resetButton.setForeground(new java.awt.Color(255, 255, 255));
        resetButton.setText("RESET");
        resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(153, 0, 0));
        deleteButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("DELETE");
        deleteButton.setToolTipText("");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout commandPanelLayout = new javax.swing.GroupLayout(commandPanel);
        commandPanel.setLayout(commandPanelLayout);
        commandPanelLayout.setHorizontalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        commandPanelLayout.setVerticalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        presentationPanel.setBackground(new java.awt.Color(255, 255, 204));
        presentationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        presentationPanel.setForeground(new java.awt.Color(0, 0, 0));

        clientTable.setBackground(new java.awt.Color(102, 0, 0));
        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reg Number", "First Name", "Last Name", "Phone Number", "Email Address", "Client Category", "Image"
            }
        ));
        clientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientTable);

        javax.swing.GroupLayout presentationPanelLayout = new javax.swing.GroupLayout(presentationPanel);
        presentationPanel.setLayout(presentationPanelLayout);
        presentationPanelLayout.setHorizontalGroup(
            presentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        presentationPanelLayout.setVerticalGroup(
            presentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(presentationPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(inputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(commandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(presentationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        client = new Client();
        
        client.setRegistrationNumber( registrationNumberTextField.getText());
        client.setFirstName(firstNameTextField.getText());
        client.setLastName(lastNameTextField.getText());
        client.setPhoneNumber(phoneNumberTextField.getText());
        client.setEmail(emailTextField.getText());
        if (clientComboBox.getSelectedItem().toString().equalsIgnoreCase("student")) {
            client.setClientCategory(ClientType.Student);
        } else if (clientComboBox.getSelectedItem().toString().equalsIgnoreCase("staff")){
            client.setClientCategory(ClientType.Staff);
        }
        client.setImage(theimage);
        
        clientDao.save(client);
        retrieveClientList();
        displayClientsInTable();
        resetFields();
        
        JOptionPane.showMessageDialog(this, "Saved a Client", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_saveButtonActionPerformed

    //What happens when we click on browse image.
    private void BrowseImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseImageButtonActionPerformed
        JFileChooser imageChooser = new JFileChooser();
        imageChooser.showOpenDialog(null);
        selectedImage = imageChooser.getSelectedFile();
        thePathOfTheImage = selectedImage.getAbsolutePath();
        imagePathTextField.setText(thePathOfTheImage);
        theimage = new File(thePathOfTheImage);
        
        displaySelectedImage(thePathOfTheImage);
    }//GEN-LAST:event_BrowseImageButtonActionPerformed
    
    //Method to display the chosen Image
    public void displaySelectedImage(String thePathOfTheImage1){
        ImageIcon image = new ImageIcon(thePathOfTheImage1);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        imageLabel.setIcon(newImage);
    }
    
    //Method to display images.
    public void displayImage(byte[] ImagePhotoFileFromDatabase1){
        ImageIcon image = new ImageIcon(ImagePhotoFileFromDatabase);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        imageLabel.setIcon(newImage);
    }
    
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        client = new Client();
        
        client.setRegistrationNumber( registrationNumberTextField.getText());
        client.setFirstName(firstNameTextField.getText());
        client.setLastName(lastNameTextField.getText());
        client.setPhoneNumber(phoneNumberTextField.getText());
        client.setEmail(emailTextField.getText());
        if (clientComboBox.getSelectedItem().toString().equalsIgnoreCase("student")) {
            client.setClientCategory(ClientType.Student);
        } else if (clientComboBox.getSelectedItem().toString().equalsIgnoreCase("staff")){
            client.setClientCategory(ClientType.Staff);
        }
        client.setImage(theimage);
                
        clientDao.update(client);
        retrieveClientList();
        displayClientsInTable();
        resetFields();
        
        JOptionPane.showMessageDialog(this, "Updated Client Data!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        client = new Client();
        
        client.setRegistrationNumber( registrationNumberTextField.getText());
        client.setFirstName(firstNameTextField.getText());
        client.setLastName(lastNameTextField.getText());
        client.setPhoneNumber(phoneNumberTextField.getText());
        client.setEmail(emailTextField.getText());
        if (clientComboBox.getSelectedItem().toString().equalsIgnoreCase("student")) {
            client.setClientCategory(ClientType.Student);
        } else if (clientComboBox.getSelectedItem().toString().equalsIgnoreCase("staff")){
            client.setClientCategory(ClientType.Staff);
        }
        client.setImage(theimage);
        
        clientDao.delete(client);
        retrieveClientList();
        displayClientsInTable();
        resetFields();
        
        JOptionPane.showMessageDialog(this, "Client Data Deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        resetFields();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void clientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTableMouseClicked
        model = (DefaultTableModel) clientTable.getModel();
        int selectedRow = clientTable.getSelectedRow();
        
        registrationNumberTextField.setText(model.getValueAt(selectedRow, 0).toString());
        firstNameTextField.setText(model.getValueAt(selectedRow, 1).toString());
        lastNameTextField.setText(model.getValueAt(selectedRow, 2).toString());
        phoneNumberTextField.setText(model.getValueAt(selectedRow, 3).toString());
        emailTextField.setText(model.getValueAt(selectedRow, 4).toString());
        clientComboBox.setSelectedItem(model.getValueAt(selectedRow, 5).toString());
        imagePathTextField.setText(model.getValueAt(selectedRow, 6).toString());
        ImagePhotoFileFromDatabase = (byte[]) model.getValueAt(selectedRow, 5);
        
        displayImage(ImagePhotoFileFromDatabase);
        
    }//GEN-LAST:event_clientTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BrowseImageButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JComboBox<String> clientComboBox;
    private javax.swing.JTable clientTable;
    private javax.swing.JPanel commandPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JTextField imagePathTextField;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JPanel presentationPanel;
    private javax.swing.JTextField registrationNumberTextField;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
