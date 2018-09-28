package com.leroiv.familyTree.validator.impl;

import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.service.user.UserService;
import com.leroiv.familyTree.validator.intf.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/*
 * validator for {@link com.leroiv.familyTree.domain.User} class,
 * implements {@link com.leroiv.familyTree.validator.intf.Validator} interface
 * @author viorel cojocaru
 * @version 1.0
 * */
@Service
public class UserValidator implements Validator {
    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Required");
        if (userService.findByUserLogin(user.getLogin()) != null) {
            errors.reject("username", "duplicate.userForm.login");
        }
        if (user.getLogin().length() < 6 || user.getLogin().length() > 15) {
            errors.reject("username", "size.userForm.login");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 6 || user.getPassword().length() > 10) {
            errors.reject("password", "size.userForm.password");
        }
        if (!user.getPassword().equals(user.getPassword())) {
            errors.reject("confirmPassword", "different.userForm.password");
        }
    }
}
