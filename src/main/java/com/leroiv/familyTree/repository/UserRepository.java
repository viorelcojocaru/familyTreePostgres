package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.Role;
import com.leroiv.familyTree.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "familyTree", path = "user")
public interface UserRepository extends JpaRepository<User, Long> {
    public User findUserByLogin(String login);
}
