package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository repository;
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(int id) {
        return repository.getById(id);
    }

    @Override
    public void save(Category category) {
        repository.save(category);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }
}
