package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Country;
import com.leroiv.familyTree.repository.CountryRepository;
import com.leroiv.familyTree.service.intf.CountryServiceIntf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements CountryServiceIntf {

    private final CountryRepository countryRepository;


    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public Country saveOrUpdate(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void delete(Long id) {

    }
    @Override
    public boolean existEntry(Long id) {
        return countryRepository.existsById(id);
    }
}
