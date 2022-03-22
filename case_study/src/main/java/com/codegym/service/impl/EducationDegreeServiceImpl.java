package com.codegym.service.impl;

import com.codegym.model.EducationDegree;
import com.codegym.repository.IEducationRepository;
import com.codegym.service.IEducationService;
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
