package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.repository.PersonRepository;
import com.leroiv.familyTree.service.intf.PersonServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("springdatajpa")
public class PersonService implements PersonServiceIntf {
    @Autowired
    private PersonRepository repository;

    @Override
    public List<?> listAll() {
        List<Person> persons=new ArrayList<>();
        repository.findAll().forEach(persons::add);
        return persons;
    }

    @Override
    public Person getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Person saveOrUpdate(Person person) {
        return repository.save(person);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
