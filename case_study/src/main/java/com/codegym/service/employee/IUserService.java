package com.codegym.service.employee;

import com.codegym.model.employee.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(int id);
}
