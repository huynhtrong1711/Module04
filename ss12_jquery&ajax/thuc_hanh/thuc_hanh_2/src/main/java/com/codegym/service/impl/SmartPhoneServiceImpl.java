package com.codegym.service.impl;

import com.codegym.model.Smartphone;
import com.codegym.repository.ISmartPhoneRepository;
import com.codegym.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartPhoneServiceImpl implements ISmartPhoneService {

    @Autowired
    private ISmartPhoneRepository repository;

    @Override
    public List<Smartphone> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(int id) {
        return repository.findById(id);
    }


    @Override
    public Smartphone save(Smartphone smartPhone) {
         return repository.save(smartPhone);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
