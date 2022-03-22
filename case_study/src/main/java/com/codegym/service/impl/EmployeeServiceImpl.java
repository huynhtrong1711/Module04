package com.codegym.service.impl;

import com.codegym.model.Employee;
import com.codegym.repository.IEmployeeRepository;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return repository.findByNameEmployeeContaining(name, pageable);
    }


}
