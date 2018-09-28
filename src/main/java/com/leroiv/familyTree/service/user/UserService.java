package com.leroiv.familyTree.service.user;

import com.leroiv.familyTree.domain.Role;
import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.repository.RoleRepository;
import com.leroiv.familyTree.repository.UserRepository;
import com.leroiv.familyTree.service.user.intf.UserServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserServiceIntf {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(1));
        user.setRoles(roles);
        userRepository.save(user);
    }

    public User findByUserLogin(String login) {
        return userRepository.findUserByLogin(login);
    }
}
