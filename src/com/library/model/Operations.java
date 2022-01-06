package com.library.model;

import javax.persistence.*;

/**
 *
 * @author hirwa
 */
@Entity
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int operationId;
    private String OperationType;
    private String clientNames;
    private String bookTitle;
    private String transactionDate;
    private String returnDate;

    public Operations() {
    }

    public Operations(int operationId, String OperationType, String clientNames, String bookTitle, String transactionDate, String returnDate) {
        this.operationId = operationId;
        this.OperationType = OperationType;
        this.clientNames = clientNames;
        this.bookTitle = bookTitle;
        this.transactionDate = transactionDate;
        this.returnDate = returnDate;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getOperationType() {
        return OperationType;
    }

    public void setOperationType(String OperationType) {
        this.OperationType = OperationType;
    }

    public String getClientNames() {
        return clientNames;
    }

    public void setClientNames(String clientNames) {
        this.clientNames = clientNames;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }


    
}
