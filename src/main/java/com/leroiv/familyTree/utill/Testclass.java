package com.leroiv.familyTree.utill;

import com.leroiv.familyTree.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class Testclass {
//   @Autowired
//    private static RoleRepository roleRepository;



    public static void main(String[] args) {

        /* BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("admin: "+bCryptPasswordEncoder.encode("admin"));
        System.out.println("user: "+bCryptPasswordEncoder.encode("user"));
        System.out.println("guest: "+bCryptPasswordEncoder.encode("guest"));*/
        /*List<String> roles = new ArrayList<>();
        roleRepository.findAll().forEach(role -> roles.add(role.getName()));
        System.out.println((String[]) roles.toArray());*/
    }

}
