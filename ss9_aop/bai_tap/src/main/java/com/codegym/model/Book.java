package com.codegym.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameBook;
    private String nameAuthor;
    private String datePublication;
    private int numberOfBooks;

    @ManyToOne
    @JoinColumn(name = "id_borrow", referencedColumnName = "id")
    private CodeBorrowed codeBorrowed;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public CodeBorrowed getCodeBorrowed() {
        return codeBorrowed;
    }

    public void setCodeBorrowed(CodeBorrowed codeBorrowed) {
        this.codeBorrowed = codeBorrowed;
    }
}
