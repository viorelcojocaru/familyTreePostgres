package com.leroiv.familyTree.web;

import com.leroiv.familyTree.constants.Genders;
import com.leroiv.familyTree.constants.Pages;
import com.leroiv.familyTree.constants.Roles;
import com.leroiv.familyTree.domain.Contact;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.service.PersonService;
import com.leroiv.familyTree.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Calendar;
/*
 * Controller for {@link com.leroiv.familyTree.domain.User}'s pages
 * @author viorel cojocaru
 * @Version 1.0
 * */

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PersonService personService;

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userService.findUserByUserName(auth.getName());
        Person person = loggedUser.getUserToPerson();
        if (person == null)
            person = new Person();
        if (loggedUser.getRoles().stream().anyMatch(role -> role.getId() == Roles.ADMIN)) {
            modelAndView.addObject("admin", person);
            modelAndView.setViewName("admin");
        } else {
            return welcome(new ModelAndView());
        }
        return modelAndView;
    }

    @GetMapping(Pages.VIEW_WELCOME)
    public ModelAndView welcome(ModelAndView modelAndView) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.setViewName("welcome");
        User user = userService.findUserByUserName(auth.getName());
        Person person = user.getUserToPerson();
        if (person == null) {
            person = new Person();
            person.setGender(Genders.UNDEFINED);
        }
        Contact contact = person.getContact();
        if (contact == null) {
            contact = new Contact();
        }

        modelAndView.addObject("person", person);
        modelAndView.addObject("persons", personService.listAll());
        modelAndView.addObject("contact", contact);
        Calendar calendars = Calendar.getInstance();
        modelAndView.addObject("calendars", calendars);
        return modelAndView;
    }


}
