package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
    @Query(value = "select * from customer where last_name=:keyword", nativeQuery = true)
    Page<Customer> searchByName(@Param("keyword") String keyword, Pageable pageable);
}
