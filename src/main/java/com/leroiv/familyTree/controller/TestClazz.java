package com.leroiv.familyTree.controller;

import com.leroiv.familyTree.constants.Roles;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.domain.Role;
import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.repository.RoleRepository;
import com.leroiv.familyTree.service.PersonService;
import com.leroiv.familyTree.service.RoleService;
import com.leroiv.familyTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestClazz {
    static UserService userService;
    static PersonService personService;
    @Autowired
    static RoleRepository roleRepository;
    RoleService roleService;
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
//        System.out.println(bCryptPasswordEncoder.encode("admin"));
//        System.out.println(bCryptPasswordEncoder.encode("user"));
//        System.out.println(bCryptPasswordEncoder.encode("guest"));
        //System.out.println(bCryptPasswordEncoder.matches("user","$2a$10$13UrbXyGb30i5Gcd/I2fX.MmPzWT0/p8sBtktcPHl1NMSd/ro5576"));

        saveuser();
      //savePerson();


    }
    private static  Person  savePerson(){
        Person person=new Person();
        person.setFirstName("Mihai");
        person.setLastName("Anton");
        return personService.saveOrUpdate(person);
    }

    private static void saveuser(){
        User user=new User();
       // Role role =roleRepository.getOne((long)Roles.USER);
        Role role =new Role();
        role.setId(20l);
        role.setName("USER");
        user.addRole(role);
        user.setUserName("mihai");
        user.setPassword("mihai");
        user.setConfirmPassword("mihai");
        //user.setUserToPerson(savePerson());
        userService.saveOrUpdate(user);
    }
}
