package com.codegym.repository;

import com.codegym.model.CodeBorrowed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodeBorrowedRepository extends JpaRepository<CodeBorrowed, Integer> {
    CodeBorrowed findByCodeBorrow(String code);
}
