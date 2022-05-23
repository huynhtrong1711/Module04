package com.codegym.service.impl.employee;

import com.codegym.model.employee.Division;
import com.codegym.repository.employee.IDivisionRepository;
import com.codegym.service.employee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {

    @Autowired
    private IDivisionRepository repository;
    @Override
    public List<Division> findAll() {
        return repository.findAll();
    }
}
