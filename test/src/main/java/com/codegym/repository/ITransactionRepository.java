package com.codegym.repository;

import com.codegym.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {

    Page<Transaction> findByCustomer_NameCustomerContaining(String name, Pageable pageable);
//    Page<Transaction> findByCustomer_NameCustomerContainingAndTypeOfService_NameService(String nameCustomer,String transactionType, Pageable pageable);
}
