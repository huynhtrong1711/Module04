package com.codegym.service.impl;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository repository;
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
