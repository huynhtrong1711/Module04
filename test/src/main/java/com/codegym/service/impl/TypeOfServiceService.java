package com.codegym.service.impl;

import com.codegym.model.TypeOfService;
import com.codegym.repository.ITypeOfServiceRepository;
import com.codegym.service.ITypeOfServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfServiceService implements ITypeOfServiceService {

    @Autowired
    private ITypeOfServiceRepository repository;

    @Override
    public List<TypeOfService> findAll() {
        return repository.findAll();
    }
}
