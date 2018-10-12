package com.leroiv.familyTree.validation;

import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String userName = user.getUserName();
        User userByLogin = userService.findUserByUserName(userName);
        if (userByLogin != null) {
            errors.rejectValue("userName",
                    "userName.exists",
                    new Object[]{userName},
                    "User name " + userName + " already in use");
        }
    }
}
