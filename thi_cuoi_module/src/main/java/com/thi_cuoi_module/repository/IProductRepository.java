package com.thi_cuoi_module.repository;

import com.thi_cuoi_module.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findProductByNameProductContaining(String name, Pageable pageable);
}
