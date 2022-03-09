package com.codegym.service.impl;

import com.codegym.model.Province;
import com.codegym.repository.IProvinceRepository;
import com.codegym.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService {

    @Autowired
    private IProvinceRepository repository;

    @Override
    public List<Province> findAll() {
        return repository.findAll();
    }

    @Override
    public Province findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        repository.save(province);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
