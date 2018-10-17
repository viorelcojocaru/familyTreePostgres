package com.leroiv.familyTree.validation;

import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

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
        String password=user.getPassword();
        if (Optional.ofNullable(password).isPresent()){
            errors.rejectValue("password", "password.Empty", new Object[]{password},"Password  is required");
        }
        if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,10}$")){
            errors.rejectValue("password",
                    "password.Pattern",
                    new Object[]{password},
                    "Password  is required to be minimum six characters, at least one letter and one number.");
        }
        if (password.length()<6 || password.length()>10){
            errors.rejectValue("password",
                    "password.Size",
                    new Object[]{password},
                    "Password  size is required to be between 6 and 10 characters.");
        }
    }

}
