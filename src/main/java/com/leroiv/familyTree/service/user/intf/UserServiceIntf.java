package com.leroiv.familyTree.service.user.intf;

import com.leroiv.familyTree.domain.User;

import java.util.List;

public interface UserServiceIntf {
    public List<User> findAll();
    public void save(User user);
    public User findByUserLogin(String login);
}
