package com.codegym.repository;

import com.codegym.model.TypeOfService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeOfServiceRepository extends JpaRepository<TypeOfService, Integer> {
}
