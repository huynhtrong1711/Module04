package com.thi_cuoi_module.service.impl;

import com.thi_cuoi_module.model.Product;
import com.thi_cuoi_module.repository.IProductRepository;
import com.thi_cuoi_module.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void remove(int id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return repository.findProductByNameProductContaining(name, pageable);
    }
}
