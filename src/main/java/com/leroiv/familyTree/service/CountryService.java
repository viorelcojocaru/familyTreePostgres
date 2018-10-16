package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Country;
import com.leroiv.familyTree.repository.CountryRepository;
import com.leroiv.familyTree.service.intf.CountryServiceIntf;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements CountryServiceIntf {

    private final CountryRepository repository;


    @Override
    public List<Country> listAll() {
        return repository.findAll();
    }

    @Override
    public Country getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public Country saveOrUpdate(Country country) {
        return repository.save(country);
    }

    @Override
    public void delete(Long id) {

    }
}
