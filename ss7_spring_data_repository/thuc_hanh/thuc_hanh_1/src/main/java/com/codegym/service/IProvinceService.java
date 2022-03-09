package com.codegym.service;

import com.codegym.model.Province;

import java.util.List;

public interface IProvinceService {
    List<Province> findAll();
    Province findById(int id);
    void save(Province province);
    void remove(int id);
}
