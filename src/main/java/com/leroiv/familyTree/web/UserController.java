package com.leroiv.familyTree.web;

import com.leroiv.familyTree.constants.Pages;
import com.leroiv.familyTree.constants.Roles;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.repository.CountryRepository;
import com.leroiv.familyTree.repository.PersonRepository;
import com.leroiv.familyTree.repository.UserRepository;
import com.leroiv.familyTree.service.PersonService;
import com.leroiv.familyTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private CountryRepository countryRepo;

    @Autowired
    UserService userService;

    public UserController() {
    }


    @GetMapping(Pages.VIEW_LOGIN)
    public ModelAndView login(ModelAndView modelAndView) {

        modelAndView.setViewName("login");
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedUser = userRepository.findOneWithPersonByUserName(auth.getName()).get();
        Person person = loggedUser.getLoggedPerson();
        if (loggedUser.getRoles().stream().anyMatch(role -> role.getId()==Roles.ADMIN)) {
            modelAndView.addObject("admin", person);
            modelAndView.setViewName("admin");
        } else {
            return welcome(new ModelAndView());
        }

        return modelAndView;
    }

    @GetMapping("/"+Pages.VIEW_REGISTRATION)
    public ModelAndView registration(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(Pages.VIEW_REGISTRATION)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, ModelAndView modelAndView) {
        User userExists = userRepository.findUserByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {

            userService.saveOrUpdate(user);

            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());

            return welcome(new ModelAndView());
        }
        return modelAndView;
    }


    private PersonService personService;

    @GetMapping(Pages.VIEW_WELCOME)
    public ModelAndView welcome(ModelAndView modelAndView) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        modelAndView.setViewName("welcome");
        User loggedUser = userRepository.findOneWithPersonByUserName(auth.getName()).get();
        Person person = loggedUser.getLoggedPerson();
        modelAndView.addObject("loggedPerson", person);
        modelAndView.addObject("persons", personRepo.findAll());
        modelAndView.addObject("countrys", countryRepo.findAll());

        return modelAndView;
    }


}
