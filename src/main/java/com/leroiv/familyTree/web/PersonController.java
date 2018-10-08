package com.leroiv.familyTree.web;

import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class PersonController {


    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/editPerson/id/{id}")
    public ModelAndView edit(@PathVariable Long id, ModelAndView modelAndView) {
        Person person = personService.getById(id);
        modelAndView.addObject("person", person);
        modelAndView.addObject("persons", personService.listAll());
        modelAndView.setViewName("editPerson");
        return modelAndView;

    }

    @PostMapping("/editPerson")
    public ModelAndView save(@RequestBody Person person , ModelAndView modelAndView) {
        modelAndView.addObject("person", person);
        modelAndView.setViewName("editPerson");
        personService.saveOrUpdate(person);
        return modelAndView;
    }

}
