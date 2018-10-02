package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Role;
import com.leroiv.familyTree.repository.RoleRepository;
import com.leroiv.familyTree.service.intf.RoleServiceIntf;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("springdatajpa")
public class RoleService implements RoleServiceIntf {

    private RoleRepository roleRepository;

    @Override
    public List<?> listAll() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role saveOrUpdate(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
