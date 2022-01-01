package library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hirwa
 */
@Entity
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int operationNumber;
    private String TransactionType;
    private String client;
    private String book;
    private String transactionDate;
    private String returnDate;

    public Operations() {
    }

    public Operations(int operationNumber, String TransactionType, String client, String book, String transactionDate, String returnDate) {
        this.operationNumber = operationNumber;
        this.TransactionType = TransactionType;
        this.client = client;
        this.book = book;
        this.transactionDate = transactionDate;
        this.returnDate = returnDate;
    }

    public int getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(int operationNumber) {
        this.operationNumber = operationNumber;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String TransactionType) {
        this.TransactionType = TransactionType;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
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
