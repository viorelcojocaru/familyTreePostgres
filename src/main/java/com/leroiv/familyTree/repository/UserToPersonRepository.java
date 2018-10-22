package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.domain.UserToPerson;
import com.leroiv.familyTree.domain.UserToRole;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "familyTree", path = "user_to_person")
public interface UserToPersonRepository extends JpaRepository<UserToPerson, Long> {

    //@Query("SELECT utp FROM user_to_person utp WHERE utp.person_id = ?1")
    public UserToPerson getUserToPersonByPersonId(Long personId);

    //@Query("SELECT CASE  WHEN count(utp)> 0 THEN true ELSE false END FROM user_to_person utp WHERE utp.personId = ?1")
    public boolean existsUserToPersonByPersonId(Long personId);


}
