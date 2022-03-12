package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CodeBorrowed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codeBorrow;

    @OneToMany(mappedBy = "codeBorrowed")
    private Set<Book> book;

    public CodeBorrowed() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeBorrow() {
        return codeBorrow;
    }

    public void setCodeBorrow(String codeBorrow) {
        this.codeBorrow = codeBorrow;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
