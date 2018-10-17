package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.AppAccount;
import com.leroiv.familyTree.domain.AppAccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "familyTree", path = "app_account_type")
public interface AppAccountTypeRepository extends JpaRepository<AppAccountType, Long> {



}
