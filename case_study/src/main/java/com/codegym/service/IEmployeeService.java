package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);
    Employee findById(int id);
    void save(Employee employee);
    void remove(int id);
    Page<Employee> findByName(String name, Pageable pageable);
}
