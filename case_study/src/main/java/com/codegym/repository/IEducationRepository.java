package com.codegym.repository;

import com.codegym.model.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<EducationDegree, Integer> {
}
