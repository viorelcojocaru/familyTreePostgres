package com.leroiv.familyTree.repository;

import com.leroiv.familyTree.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "familyTree", path = "country")
public interface CountryRepository extends CrudRepository<Country, Integer> {

}
