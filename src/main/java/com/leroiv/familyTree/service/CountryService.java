package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Country;
import com.leroiv.familyTree.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository repository;

    public List<Country> findAll() {
        return repository.findAll();
    }
}
