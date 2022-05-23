package com.thi_cuoi_module.service;

import com.thi_cuoi_module.model.ProductType;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();
}
