package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.repository.PersonRepository;
import com.leroiv.familyTree.service.intf.PersonServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class PersonService implements PersonServiceIntf {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> listAll() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    @Override
    public Person getById(Long id) {
        Person person = personRepository.findById(id).get();
        return person;
    }

    @Override
    public Person saveOrUpdate(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }


    @Override
    public boolean existEntry(Long id) {
        return personRepository.existsById(id);
    }

}
