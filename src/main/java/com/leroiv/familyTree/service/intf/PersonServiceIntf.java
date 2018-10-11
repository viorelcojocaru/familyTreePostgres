package com.leroiv.familyTree.service.intf;

import com.leroiv.familyTree.domain.Person;

public interface PersonServiceIntf extends CRUDService<Person>{

    boolean existPerson(Long id);
}
