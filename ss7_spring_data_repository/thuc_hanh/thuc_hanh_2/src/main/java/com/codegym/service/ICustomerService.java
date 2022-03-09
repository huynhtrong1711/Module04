package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    Customer findById(int id);
    void save(Customer customer);
    void remove(int id);
    Page<Customer> searchByName(String name,Pageable pageable);
}
