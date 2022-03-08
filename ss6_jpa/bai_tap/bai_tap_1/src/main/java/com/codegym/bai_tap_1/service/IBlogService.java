package com.codegym.bai_tap_1.service;

import com.codegym.bai_tap_1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void remove(int id);
}
