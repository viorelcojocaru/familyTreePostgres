package com.leroiv.familyTree.web;

import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    @PostMapping(value = "/editPerson/save" )
    public ModelAndView save(@Valid Person person , BindingResult bindingResult , ModelAndView modelAndView) {
        modelAndView.addObject("person", person);
        modelAndView.setViewName("/editPerson");
        personService.saveOrUpdate(person);
        modelAndView.setViewName("/editPerson/id/"+person.getId());
        return modelAndView;
    }


    @GetMapping("create-person")
    public ModelAndView createUserView() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("editPerson");
        mav.addObject("newPerson", new Person());
        mav.addObject("persons", personService.listAll());
        return mav;
    }

    @PostMapping("editPerson")
    public ModelAndView createPerson(@Valid Person person, BindingResult result) {
        personService.saveOrUpdate(person);
        return new ModelAndView();
    }


}
