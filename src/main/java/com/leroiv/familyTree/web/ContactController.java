package com.leroiv.familyTree.web;

import com.leroiv.familyTree.domain.Contact;
import com.leroiv.familyTree.service.CountryService;
import com.leroiv.familyTree.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class ContactController {

    private final CountryService countryService;


    private final PersonService personService;

    @Autowired
    public ContactController(PersonService personService, CountryService countryService) {
        this.personService = personService;
        this.countryService = countryService;

    }

    @GetMapping("/editPerson")
    public ModelAndView contact(ModelAndView modelAndView) {
        modelAndView.addObject("contact", new Contact());
        modelAndView.setViewName("editPerson");
        return modelAndView;
    }

}
