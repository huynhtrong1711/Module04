package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.repository.IBookRepository;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService{

    @Autowired
    private IBookRepository repository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        repository.save(book);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
