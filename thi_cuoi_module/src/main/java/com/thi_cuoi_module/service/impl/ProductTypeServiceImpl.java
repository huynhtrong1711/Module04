package com.thi_cuoi_module.service.impl;

import com.thi_cuoi_module.model.ProductType;
import com.thi_cuoi_module.repository.IProductTypeRepository;
import com.thi_cuoi_module.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements IProductTypeService {

    @Autowired
    private IProductTypeRepository repository;

    @Override
    public List<ProductType> findAll() {
        return repository.findAll();
    }
}
