package com.codegym.service;

import com.codegym.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartPhoneService {
    List<Smartphone> findAll();

    Optional<Smartphone> findById(int id);

    Smartphone save(Smartphone smartPhone);

    void remove(int id);
}
