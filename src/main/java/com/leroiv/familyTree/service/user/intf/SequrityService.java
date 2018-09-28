package com.leroiv.familyTree.service.user.intf;

public interface SequrityService {
    String findLoggedInUserName();
    void autoLogin(String login, String password);
}
