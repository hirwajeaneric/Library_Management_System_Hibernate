package com.library.model;

import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author hirwa
 */
@Entity
@Table(name="bookCategory")
public class BookCategory {
    @Id
    private String categoryCode;
    @Column(name="categoryName")
    private String categoryName;
    @Cascade(CascadeType.ALL)
    @OneToMany(mappedBy = "bookCategory")
    private List<Book> books;

    public BookCategory() {
    }

    public BookCategory(String categoryCode, String categoryName, List<Book> books) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.books = books;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
