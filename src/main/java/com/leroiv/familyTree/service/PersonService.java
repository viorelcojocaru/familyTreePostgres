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

public class PersonService implements PersonServiceIntf {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserService userService;
    @Override
    public List<?> listAll() {
        List<Person> persons=new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).get();
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
    public boolean existPerson(Long id) {
        return personRepository.existsById(id);
    }
}
