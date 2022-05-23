package com.thi_cuoi_module.repository;

import com.thi_cuoi_module.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {
}
