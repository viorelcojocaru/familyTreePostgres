package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Contact;
import com.leroiv.familyTree.repository.ContactRepository;
import com.leroiv.familyTree.service.intf.ContactserviceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RepositoryRestResource(collectionResourceRel = "familyTree", path = "contact")
public class ContactService implements ContactserviceIntf {
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
}
