package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Country;
import com.leroiv.familyTree.repository.CountryRepository;
import com.leroiv.familyTree.service.intf.CountryServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CountryService implements CountryServiceIntf {
    @Autowired
    private CountryRepository repository;


    @Override
    public List<?> listAll() {
        return null;
    }

    @Override
    public Country getById(Long id) {
        return null;
    }

    @Override
    public Country saveOrUpdate(Country domainObject) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
