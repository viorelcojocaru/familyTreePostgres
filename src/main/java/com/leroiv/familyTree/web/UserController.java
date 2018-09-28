package com.leroiv.familyTree.web;

import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.service.user.UserService;
import com.leroiv.familyTree.service.user.intf.SequrityService;
import com.leroiv.familyTree.validator.impl.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * Controller for {@link com.leroiv.familyTree.domain.User}'s pages
 * @author viorel cojocaru
 * @Version 1.0
 * */

@Controller
@RequestMapping("/")
public class UserController {
    public static final String VIEW_REGISTRATION = "registration";
    public static final String WIEW_WELCOME = "/welcome";
    public static final String WIEW_LOGIN = "login";
    public static final String WIEW_ADMIN = "admin";

    @Autowired
    UserService userService;
    @Autowired
    SequrityService sequrityService;
    @Autowired
    UserValidator userValidator;

    @GetMapping(value = VIEW_REGISTRATION)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping(value = VIEW_REGISTRATION)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return VIEW_REGISTRATION;
        }
        userService.save(userForm);
        sequrityService.autoLogin(userForm.getLogin(), userForm.getConfirmPassword());
        return WIEW_WELCOME;
    }

    @GetMapping(value = WIEW_LOGIN)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "login  or password is incorrect");
        }
        if (logout != null) {
            model.addAttribute("message", "logout  successfully");
        }
        return WIEW_LOGIN;
    }
    @GetMapping(value =  WIEW_WELCOME)
    public String welcome(Model model) {
        return WIEW_LOGIN;
    }
    @GetMapping(value =  WIEW_ADMIN)
    public String admin(Model model) {
        return WIEW_ADMIN;
    }

}
