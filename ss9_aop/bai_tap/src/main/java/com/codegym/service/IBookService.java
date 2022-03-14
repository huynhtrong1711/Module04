package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    void save(Book book);
    Book findById(int id);
}
