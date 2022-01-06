package com.library.model;

import javax.persistence.*;

/**
 *
 * @author hirwa
 */
@Entity
@Table(name="account")
public class Account {
    private String firstName;
    private String lastName;
    private String emailAddress;
    @Id
    private String userName;
    private String createpassword;
    private String confirmPassword;

    public Account() {
    }

    public Account(String firstName, String lastName, String emailAddress, String userName, String createpassword, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.userName = userName;
        this.createpassword = createpassword;
        this.confirmPassword = confirmPassword;
    }

    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreatepassword() {
        return createpassword;
    }

    public void setCreatepassword(String createpassword) {
        this.createpassword = createpassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    
}
