package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;


@RepositoryRestResource(collectionResourceRel = "familyTree", path = "contact")
public interface ContactRepository  extends JpaRepository<Contact, Long> {
}
