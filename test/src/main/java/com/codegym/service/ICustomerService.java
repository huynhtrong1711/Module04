package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Page<Customer> findByName(String name, Pageable pageable);
}
