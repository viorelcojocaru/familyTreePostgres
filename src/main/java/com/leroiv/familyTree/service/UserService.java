package com.leroiv.familyTree.service;

import com.leroiv.familyTree.constants.Roles;
import com.leroiv.familyTree.domain.Role;
import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.repository.RoleRepository;
import com.leroiv.familyTree.repository.UserRepository;
import com.leroiv.familyTree.service.intf.UserServiceIntf;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserServiceIntf {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveOrUpdate(User user) {
        if (user.getPassword() != null) {
            user.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setPassword(user.getEncryptedPassword());
        }
        Role role =roleRepository.findById(new Long(Roles.USER)).get();
        user.addRole(role);
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

}
