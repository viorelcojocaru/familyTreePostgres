package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.Person;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "familyTree", path = "person")
public interface PersonRepository extends CrudRepository<Person, Long> {



   /* @EntityGraph(attributePaths = "person")
    public Optional<Person> findOneWithPersonByUserId(String username);
    @Query("select user from User user where user.userName = ?#{principal.username}")
    Person findCurretUser();*/

}
