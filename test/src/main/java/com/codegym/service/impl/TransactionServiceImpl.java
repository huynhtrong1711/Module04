package com.codegym.service.impl;

import com.codegym.model.Transaction;
import com.codegym.repository.ITransactionRepository;
import com.codegym.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private ITransactionRepository repository;

    @Override
    public Page<Transaction> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Transaction findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Transaction transaction) {
        repository.save(transaction);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Transaction> findByName(String name, Pageable pageable) {
        return repository.findByCustomer_NameCustomerContaining(name, pageable) ;
    }

//    @Override
//    public Page<Transaction> findByNameCustomerAndTransactionType(String name, String nameTransactionType, Pageable pageable) {
//        return repository.findByCustomer_NameCustomerContainingAndTypeOfService_NameService(name, nameTransactionType, pageable);
//    }

}
