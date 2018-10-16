package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;


@RepositoryRestResource(collectionResourceRel = "familyTree", path = "person")
public interface PersonRepository extends JpaRepository<Person, Long> {

}
