package com.leroiv.familyTree.service.intf;

import com.leroiv.familyTree.domain.User;

public interface UserServiceIntf extends CRUDService<User> {
    public User findUserByUserName(String userName);

}