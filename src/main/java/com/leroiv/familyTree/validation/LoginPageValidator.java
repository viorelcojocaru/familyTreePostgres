package com.leroiv.familyTree.validation;

import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class LoginPageValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String userName = user.getUserName();
        User userByLogin = userService.findUserByUserName(userName);
        if (userByLogin == null) {
            errors.rejectValue("userName",
                    "userName.notExists",
                    new Object[]{userName},
                    "User name " + userName + " not in use");
            String password=user.getPassword();
            if (Optional.ofNullable(password).isPresent()){
                errors.rejectValue("password", "password.Empty", new Object[]{password},"Password  is required");
            }
        }

    }
}
