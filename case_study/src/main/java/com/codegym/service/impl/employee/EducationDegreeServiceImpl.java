package com.codegym.service.impl.employee;

import com.codegym.model.employee.EducationDegree;
import com.codegym.repository.employee.IEducationRepository;
import com.codegym.service.employee.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationService {

    @Autowired
    private IEducationRepository repository;

    @Override
    public List<EducationDegree> findAll() {
        return repository.findAll();
    }
}
