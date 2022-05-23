package com.codegym.repository.employee;

import com.codegym.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<EducationDegree, Integer> {
}
