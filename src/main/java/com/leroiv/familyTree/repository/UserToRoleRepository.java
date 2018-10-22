package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.domain.UserToRole;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "familyTree", path = "user_to_role")
public interface UserToRoleRepository extends JpaRepository<UserToRole, Long> {


}
