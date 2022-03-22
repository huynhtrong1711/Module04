package com.codegym.service;

import com.codegym.model.EducationDegree;

import java.util.List;

public interface IEducationService {

    List<EducationDegree> findAll();
}
