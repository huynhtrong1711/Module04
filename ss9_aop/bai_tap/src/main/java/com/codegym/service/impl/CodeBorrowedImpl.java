package com.codegym.service.impl;

import com.codegym.model.CodeBorrowed;
import com.codegym.repository.ICodeBorrowedRepository;
import com.codegym.service.ICodeBorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CodeBorrowedImpl implements ICodeBorrowedService {

    @Autowired
    private ICodeBorrowedRepository repository;

    @Override
    public CodeBorrowed findByCode(String code) {
        return repository.findByCodeBorrow(code);

    }

    @Override
    public void save(CodeBorrowed codeBorrowed) {
        repository.save(codeBorrowed);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
