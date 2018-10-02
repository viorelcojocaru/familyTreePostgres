package com.leroiv.familyTree.constants;

import com.leroiv.familyTree.domain.Role;
import com.leroiv.familyTree.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Roles {
    public static final int ADMIN = 10, USER = 20, GUEST = 30;

    private static Set<Role> roles = new HashSet<>();
@Autowired
    private static RoleRepository roleRepository;

//    public static String getRoleName( int roleId) {
//       roleRepository.findAll().forEach(role-> roles.add(role));
//        return roles.stream().filter(role->role.getId()==roleId)
//                .map(role -> role.getName()).collect(Collectors.joining(""));
//    }
    public static String getRoleName( int roleId) {
       roleRepository.findAll().forEach(role-> roles.add(role));
        return roles.stream().filter(role -> role.getId()==roleId).findAny()
                .orElse(null).getName();
    }
}
