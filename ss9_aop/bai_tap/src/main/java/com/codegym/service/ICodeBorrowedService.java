package com.codegym.service;

import com.codegym.model.CodeBorrowed;

import java.util.List;

public interface ICodeBorrowedService {
    CodeBorrowed findByCode(String code);
    void save(CodeBorrowed codeBorrowed);
    void remove(int id);
}
