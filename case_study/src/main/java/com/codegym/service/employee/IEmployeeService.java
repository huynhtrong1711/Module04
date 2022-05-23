package com.codegym.service.employee;

import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable);
    Employee findById(int id);
    void save(Employee employee);
    void remove(int id);
    Page<Employee> findByName(String name, Pageable pageable);
}
