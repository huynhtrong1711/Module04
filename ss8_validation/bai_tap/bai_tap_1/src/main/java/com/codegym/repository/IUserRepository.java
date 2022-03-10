package com.codegym.repository;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IUserRepository extends JpaRepository<User, Integer> {
}
