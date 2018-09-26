package com.leroiv.familyTree.web;

import com.leroiv.familyTree.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class PersonController {
    private static final String VIEW_PERSON = "person";

    @Autowired
    PersonRepository repository;

    @GetMapping(value = "person")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName(VIEW_PERSON);
        modelAndView.addObject("person", repository.findAll());
        return modelAndView;
    }
}
