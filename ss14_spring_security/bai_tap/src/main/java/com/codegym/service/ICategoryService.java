package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;

public interface ICategoryService{
    List<Category> findAll();
    Category findById(int id);
    void save(Category category);
    void remove(int id);
}
