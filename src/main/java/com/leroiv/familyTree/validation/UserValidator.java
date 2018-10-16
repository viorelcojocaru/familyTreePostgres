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
        String passwors=user.getPassword();
        if (!passwors.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,10}$")){
            errors.rejectValue("password",
                    "password.Pattern",
                    new Object[]{passwors},
                    "Password  is required to be minimum six characters, at least one letter and one number.");
        }
        if (passwors.length()<6 || passwors.length()>10){
            errors.rejectValue("password",
                    "password.Size",
                    new Object[]{passwors},
                    "Password  size is required to be between 6 and 10 characters.");
        }
    }
}
