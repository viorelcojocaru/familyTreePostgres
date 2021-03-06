package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Contact;
import com.leroiv.familyTree.repository.ContactRepository;
import com.leroiv.familyTree.service.intf.ContactServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactService implements ContactServiceIntf {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<?> listAll() {
        return null;
    }

    @Override
    public Contact getById(Long id) {
        return contactRepository.getOne(id);
    }

    @Override
    public Contact saveOrUpdate(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void delete(Long id) {

    }
    @Override
    public boolean existEntry(Long id) {
        return contactRepository.existsById(id);
    }
}
