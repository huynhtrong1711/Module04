package com.codegym.service.employee;

import com.codegym.model.employee.EducationDegree;

import java.util.List;

public interface IEducationService {

    List<EducationDegree> findAll();
}
