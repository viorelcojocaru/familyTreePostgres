package com.leroiv.familyTree.web;

import com.leroiv.familyTree.domain.User;
import com.leroiv.familyTree.repository.CountryRepository;
import com.leroiv.familyTree.repository.PersonRepository;
import com.leroiv.familyTree.repository.UserRepository;
import com.leroiv.familyTree.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/*
 * Controller for {@link com.leroiv.familyTree.domain.User}'s pages
 * @author viorel cojocaru
 * @Version 1.0
 * */

@RestController
@RequestMapping("/")
public class UserController {
    public static final String VIEW_REGISTRATION = "/registration";
    public static final String VIEW_WELCOME = "/welcome";
    public static final String VIEW_LOGIN = "/login";
    public static final String VIEW_ADMIN = "/admin";

    public UserController() {
    }

    @GetMapping(value = VIEW_REGISTRATION)
    public String registration(ModelAndView model) {
        model.addObject("userForm" ,new User());
        return VIEW_REGISTRATION;
    }
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private CountryRepository countryRepo;

    private  User user;
    private PersonService personService;
    @GetMapping(value = VIEW_WELCOME)
    public ModelAndView welcome(ModelAndView modelAndView) {

        modelAndView.setViewName(VIEW_WELCOME);
//        modelAndView.addObject("currentPerson", userRepository.findOneWithPersonByUserName(user.getUserName()));
        modelAndView.addObject("persons", personRepo.findAll());
        modelAndView.addObject("countrys", countryRepo.findAll());
        return modelAndView;
    }
    @GetMapping(value=VIEW_LOGIN)
    public ModelAndView login(ModelAndView modelAndView){
        //, @AuthenticationPrincipal User user
        this.user=user;
        modelAndView.setViewName(VIEW_LOGIN);
        return modelAndView;
    }
    @GetMapping(value = VIEW_ADMIN)
    public ModelAndView admin(ModelAndView modelAndView){
        modelAndView.setViewName(VIEW_ADMIN);

        return modelAndView;
    }

}
