package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@RepositoryRestResource(collectionResourceRel = "familyTree", path = "user")
public interface UserRepository extends JpaRepository<User, Long> {


    @EntityGraph(attributePaths = "loggedPerson")
    public Optional<User> findOneWithPersonByUserName(String userName);

    @EntityGraph(attributePaths = "roles")
    public Optional<User> findOneWithRoleByUserName(String userName);

    @Query("select user from User user where user.userName = ?#{principal.username}")
    User findCurretUser();

    User findUserByUserName(String username);

    User save(User user);


}
