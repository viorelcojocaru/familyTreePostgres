package com.leroiv.familyTree.web;

import com.leroiv.familyTree.constants.Pages;
import com.leroiv.familyTree.constants.Roles;
import com.leroiv.familyTree.domain.Contact;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.repository.CountryRepository;
import com.leroiv.familyTree.service.ContactService;
import com.leroiv.familyTree.service.CountryService;
import com.leroiv.familyTree.service.PersonService;
import com.leroiv.familyTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
/*
 * Controller for {@link com.leroiv.familyTree.domain.User}'s pages
 * @author viorel cojocaru
 * @Version 1.0
 * */

@RestController
@RequestMapping("/")
public class UserController {

    private final CountryService countryService;
    private final UserService userService;
    private final PersonService personService;
    private final ContactService contactService;

    @Autowired
    public UserController(CountryService countryService,
                          UserService userService,
                          PersonService personService,
                          ContactService contactService) {
        this.personService=personService;
        this.countryService = countryService;
        this.userService=userService;
        this.contactService=contactService;

    }


    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userService.findUserByUserName(auth.getName());
        Person person = loggedUser.getUserToPerson();
        if (loggedUser.getRoles().stream().anyMatch(role -> role.getId() == Roles.ADMIN)) {
            modelAndView.addObject("admin", person);
            modelAndView.setViewName("admin");
        } else {
            return welcome(new ModelAndView());
        }
        return modelAndView;
    }

    @GetMapping("/" + Pages.VIEW_REGISTRATION)
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(Pages.VIEW_REGISTRATION)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, ModelAndView modelAndView) {
        User userExists = userService.findUserByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            personService.saveOrUpdate(user.getUserToPerson());
            userService.saveOrUpdate(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            return login(new ModelAndView());
        }
        return modelAndView;
    }

    @GetMapping(Pages.VIEW_WELCOME)
    public ModelAndView welcome(ModelAndView modelAndView) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.setViewName("welcome");
        User user = userService.findUserByUserName(auth.getName());
        Person person = user.getUserToPerson();
        modelAndView.addObject("genders", person.getGenders());
        modelAndView.addObject("person", person);
        modelAndView.addObject("persons", personService.listAll());
        modelAndView.addObject("countrys", countryService.listAll());

        return modelAndView;
    }

    @PostMapping(Pages.VIEW_WELCOME)
    public ModelAndView newPerson(@Valid Person person, BindingResult bindingResult, ModelAndView modelAndView) {
        modelAndView.setViewName("welcome");
        person.setGender(person.getCurrentGender().getId().intValue());
        personService.saveOrUpdate(person);
        modelAndView.addObject("successMessage", "Person " + person.getFirstName() + " " + person.getLastName() + "has been saved successfully");
        return welcome(modelAndView);
    }

    @PutMapping(Pages.VIEW_WELCOME + "/{id}")
    public ModelAndView updatePerson(@PathVariable String id, @RequestBody Person person, ModelAndView modelAndView) {
        if (id != null) {
            modelAndView.setViewName("welcome");
            personService.saveOrUpdate(person);
            modelAndView.addObject("successMessage", "Person " + person.getFirstName() + " " + person.getLastName() + "has been updated successfully");
        }
        return modelAndView;
    }

    @GetMapping("/" + Pages.VIEW_WELCOME)
    public ModelAndView contact(ModelAndView modelAndView) {
        modelAndView.addObject("contact", new Contact());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/" + Pages.VIEW_WELCOME)
    public ModelAndView saveContact(@PathVariable String id, @RequestBody Contact contact, ModelAndView modelAndView) {
        if (id != null) {
            contactService.saveOrUpdate(contact);
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }


}
