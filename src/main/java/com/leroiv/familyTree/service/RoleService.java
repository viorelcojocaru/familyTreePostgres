package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Role;
import com.leroiv.familyTree.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class RoleService  {
    @Autowired
    private RoleRepository roleRepository;
    public List<Role> findAll(){return roleRepository.findAll();}
    public void save(Role role){ roleRepository.save(role); }
}
