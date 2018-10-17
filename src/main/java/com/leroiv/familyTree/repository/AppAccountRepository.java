package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.AppAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "familyTree", path = "app_account")
public interface AppAccountRepository extends JpaRepository<AppAccount, Long> {
    @Query("select a from app_account a where a.person_id = ?1 and a.type_id = ?2")
    public AppAccount getAppAccountBy(long personId, long typeId);
}
