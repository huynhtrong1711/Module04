package com.codegym.service.impl.employee;

import com.codegym.model.employee.User;
import com.codegym.repository.employee.IUserRepository;
import com.codegym.service.employee.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository repository;
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(int id) {
        return null;
    }
}
