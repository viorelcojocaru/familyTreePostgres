package com.leroiv.familyTree.web;

import com.leroiv.familyTree.constants.Pages;
import com.leroiv.familyTree.domain.Contact;
import com.leroiv.familyTree.repository.CountryRepository;
import com.leroiv.familyTree.repository.PersonRepository;
import com.leroiv.familyTree.service.PersonService;
import com.leroiv.familyTree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
@RequestMapping("/")

public class ContactController {

    @Autowired
    private CountryRepository countryRepo;


    @Autowired
    private PersonService personService;

    @GetMapping("/"+ Pages.VIEW_WELCOME)
    public ModelAndView contact(ModelAndView modelAndView) {
        modelAndView.addObject("contact", new Contact());
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    @PostMapping("/"+Pages.VIEW_WELCOME)
    public ModelAndView saveContact(ModelAndView modelAndView) {
        modelAndView.addObject("contact", new Contact());
        modelAndView.setViewName("registration");
        return modelAndView;
    }
}
