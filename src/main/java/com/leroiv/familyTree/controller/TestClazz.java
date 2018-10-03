package com.leroiv.familyTree.controller;

import com.leroiv.familyTree.constants.Roles;
import com.leroiv.familyTree.domain.Role;
import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.repository.RoleRepository;
import com.leroiv.familyTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestClazz {
    static UserService userService;
    @Autowired
    static RoleRepository roleRepository;
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
//        System.out.println(bCryptPasswordEncoder.encode("admin"));
//        System.out.println(bCryptPasswordEncoder.encode("user"));
//        System.out.println(bCryptPasswordEncoder.encode("guest"));
        //System.out.println(bCryptPasswordEncoder.matches("user","$2a$10$13UrbXyGb30i5Gcd/I2fX.MmPzWT0/p8sBtktcPHl1NMSd/ro5576"));

        User user=new User();
        Role role =roleRepository.findById(new Long(Roles.USER)).get();
        user.addRole(role);
        user.setUserName("Ion");user.setId(10l);
        user.setPassword("Ion");
        user.setConfirmPassword("Ion");
        userService.saveOrUpdate(user);
    }
}
