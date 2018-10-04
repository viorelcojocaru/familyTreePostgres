package com.leroiv.familyTree.service;

import com.leroiv.familyTree.domain.Role;
import com.leroiv.familyTree.repository.RoleRepository;
import com.leroiv.familyTree.service.intf.RoleServiceIntf;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService implements RoleServiceIntf {

    private RoleRepository roleRepository;

    @Override
    public List<Role> listAll() {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.getOne(id);
    }

    @Override
    public Role saveOrUpdate(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    public  String getRoleName( int roleId) {
        return listAll().stream().filter(role -> role.getId().intValue()==roleId).findAny().orElse(null).getName();
    }
}
