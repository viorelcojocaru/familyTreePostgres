package com.leroiv.familyTree.controller;

import com.leroiv.familyTree.BC.AccountBC;
import com.leroiv.familyTree.constants.AppAccountTypes;
import com.leroiv.familyTree.constants.Pages;
import com.leroiv.familyTree.domain.AppAccountType;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.repository.AppAccountTypeRepository;
import com.leroiv.familyTree.service.AppAccountTypeService;
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
    private final AppAccountTypeService appAccountTypeService;

    @GetMapping(Pages.VIEW_REGISTRATION)
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(Pages.VIEW_REGISTRATION)
    public String handleRegistration(@Valid User user, BindingResult bindingResult) throws Exception {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/registration";
        }
        Person person = user.getUserToPerson();

        personService.saveOrUpdate(person);
        if (person == null) {
            throw new Exception("Error on save Person value object");
        }
        userService.saveOrUpdate(user);
        if (user == null) {
            personService.delete(person.getId());
            throw new Exception("Error on save User value object");
        }
        AppAccountType appAccountType = appAccountTypeService.getById(AppAccountTypes.ROOT);
        if (appAccountType == null) {
            if (personService.existEntry(person.getId()))
                personService.delete(person.getId());
            if (userService.existEntry(user.getId()))
                userService.delete(user.getId());
            throw new Exception("Error on get appAccountTyepe");
        }
        AccountBC.getInstance().createAppAccount(person, appAccountType);
        return "redirect:/login";
    }

}
