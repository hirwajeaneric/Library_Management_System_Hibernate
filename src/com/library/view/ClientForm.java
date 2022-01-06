package com.library.view;

import java.awt.Image;
import java.io.*;
import java.util.List;
import java.util.logging.*;
import javax.swing.*;
import com.library.controller.GenericDao;
import com.library.model.*;
import javax.swing.table.DefaultTableModel;

public class ClientForm extends javax.swing.JInternalFrame {

    int selectedRow;
    byte[] person_image;
    FileInputStream fileinputstream;
    String thePathOfTheImage;
    File theimage, selectedImage;    
    byte[] ImagePhotoFileFromDatabase;
    List<Client> clientList;
    Client client = new Client();
    GenericDao<Client> clientDao = new GenericDao(Client.class);
    DefaultTableModel model;
    
    public ClientForm() {
        initComponents();
        getClientListFromDao();
        displayClients();
    }
    
    public void getClientListFromDao() {
        clientList = clientDao.retrieveAll(client);
    }
    
    private void displayClients() {   
        model = (DefaultTableModel) clientTable.getModel();
        model.setRowCount(0);
        
        for (Client aClient : clientList) {
            model.addRow(new Object[]{
                aClient.getRegistrationNumber(),
                aClient.getFirstName(),
                aClient.getLastName(),
                aClient.getPhoneNumber(),
                aClient.getEmail(),
                aClient.getClientCategory(),
                aClient.getImage()
            });
        }
    }

    private void resetFields(){
        registrationNumberTextField.setText(null);
        firstNameTextField.setText(null);
        lastNameTextField.setText(null);
        phoneNumberTextField.setText(null);
        emailTextField.setText(null);
        clientComboBox.setSelectedIndex(0);
        imageLabel.setIcon(null);
        imagePathTextField.setText(null);
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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        TitleLabel.setText("CLIENTS");
        jPanel1.add(TitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 18, -1, -1));

        inputPanel.setBackground(new java.awt.Color(255, 255, 204));
        inputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        inputPanel.setForeground(new java.awt.Color(0, 0, 0));
        inputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Registration Number");
        inputPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 30, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("First Name");
        inputPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 64, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Last Name");
        inputPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 96, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Phone Number");
        inputPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 128, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Email");
        inputPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 156, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Client Category");
        inputPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 188, -1, -1));

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
        inputPanel.add(BrowseImageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 219, -1, 34));

        registrationNumberTextField.setBackground(new java.awt.Color(102, 51, 0));
        registrationNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        inputPanel.add(registrationNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 28, 153, -1));

        firstNameTextField.setBackground(new java.awt.Color(102, 51, 0));
        firstNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        inputPanel.add(firstNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 60, 153, -1));

        lastNameTextField.setBackground(new java.awt.Color(102, 51, 0));
        lastNameTextField.setForeground(new java.awt.Color(255, 255, 255));
        inputPanel.add(lastNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 92, 153, -1));

        phoneNumberTextField.setBackground(new java.awt.Color(102, 51, 0));
        phoneNumberTextField.setForeground(new java.awt.Color(255, 255, 255));
        inputPanel.add(phoneNumberTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 124, 153, -1));

        emailTextField.setBackground(new java.awt.Color(102, 51, 0));
        emailTextField.setForeground(new java.awt.Color(255, 255, 255));
        inputPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 154, 153, -1));

        clientComboBox.setBackground(new java.awt.Color(102, 51, 0));
        clientComboBox.setForeground(new java.awt.Color(255, 255, 255));
        clientComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Staff" }));
        inputPanel.add(clientComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 184, 153, -1));

        imagePanel.setBackground(new java.awt.Color(51, 51, 51));
        imagePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        imagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        imagePanel.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 147, 140));

        inputPanel.add(imagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 219, 153, 146));

        imagePathTextField.setBackground(new java.awt.Color(102, 51, 0));
        imagePathTextField.setForeground(new java.awt.Color(255, 255, 255));
        inputPanel.add(imagePathTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 264, 125, -1));

        jPanel1.add(inputPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 55, 330, 380));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        commandPanelLayout.setVerticalGroup(
            commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(commandPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(commandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(commandPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 56, -1, 90));

        presentationPanel.setBackground(new java.awt.Color(255, 255, 204));
        presentationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inputs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 11), new java.awt.Color(0, 0, 0))); // NOI18N
        presentationPanel.setForeground(new java.awt.Color(0, 0, 0));

        clientTable.setBackground(new java.awt.Color(0, 0, 0));
        clientTable.setForeground(new java.awt.Color(255, 255, 255));
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

        jPanel1.add(presentationPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(348, 152, 574, -1));

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
        if (clientComboBox.getSelectedItem().toString().equalsIgnoreCase("Student")) {
            client.setClientCategory(ClientType.Student);
        } else if (clientComboBox.getSelectedItem().toString().equalsIgnoreCase("Staff")){
            client.setClientCategory(ClientType.Staff);
        }
        client.setImage(person_image);
        
        clientDao.save(client);
        getClientListFromDao();
        displayClients();
        resetFields();
        
        JOptionPane.showMessageDialog(this, "Saved a Client", "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void BrowseImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrowseImageButtonActionPerformed
        JFileChooser imageChooser = new JFileChooser();
        imageChooser.showOpenDialog(null);
        selectedImage = imageChooser.getSelectedFile();
        thePathOfTheImage = selectedImage.getAbsolutePath();
        imagePathTextField.setText(thePathOfTheImage);
        theimage = new File(thePathOfTheImage);
       
        convertImageFileIntoByteArray(theimage);
        displaySelectedImage(thePathOfTheImage);
    }//GEN-LAST:event_BrowseImageButtonActionPerformed
    
    public byte[] convertImageFileIntoByteArray(File image) {
        try {
            fileinputstream = new FileInputStream(theimage);
            
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            
            byte[] buf = new byte[2048];
            for(int readNum; (readNum = fileinputstream.read(buf))!=-1;){
                byteArrayOutputStream.write(buf,0,readNum);
            }
            person_image = byteArrayOutputStream.toByteArray();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return person_image;
    }
    
    public void displaySelectedImage(String thePathOfTheImage1){
        ImageIcon image = new ImageIcon(thePathOfTheImage1);
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
        imageLabel.setIcon(newImage);
    }
    
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
        person_image=imagePathTextField.getText().getBytes();
        client.setImage(person_image);
                
        clientDao.update(client);
        getClientListFromDao();
        displayClients();
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
        person_image=imagePathTextField.getText().getBytes();
        client.setImage(person_image);
        
        clientDao.delete(client);
        getClientListFromDao();
        displayClients();
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
        ImagePhotoFileFromDatabase = (byte[]) model.getValueAt(selectedRow, 6);
        
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
