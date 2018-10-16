package com.leroiv.familyTree.controller;

import com.leroiv.familyTree.constants.Pages;
import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.service.PersonService;
import com.leroiv.familyTree.service.UserService;
import com.leroiv.familyTree.validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserValidator userValidator;
    private final UserService userService;
    private final PersonService personService;

    @GetMapping(Pages.VIEW_REGISTRATION)
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(Pages.VIEW_REGISTRATION)
    public String handleRegistration(@Valid User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/registration";
        }
        personService.saveOrUpdate(user.getUserToPerson());
        userService.saveOrUpdate(user);
        return "redirect:/login";

    }
}
