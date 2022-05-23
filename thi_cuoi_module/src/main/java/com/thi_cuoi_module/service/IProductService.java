package com.thi_cuoi_module.service;

import com.thi_cuoi_module.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    Product findById(int id);
    void save(Product product);
    void remove(int id);
    Page<Product> findByName(String name, Pageable pageable);
}
