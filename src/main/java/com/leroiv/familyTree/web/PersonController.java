package com.leroiv.familyTree.web;

import com.leroiv.familyTree.constants.Pages;
import com.leroiv.familyTree.domain.Contact;
import com.leroiv.familyTree.domain.Country;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.service.CountryService;
import com.leroiv.familyTree.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;
    private final CountryService countryService;

    @GetMapping("/editPerson/id/{id}")
    public ModelAndView getPersonById(@PathVariable Long id, ModelAndView modelAndView) {
        Person person;
        if (id==0)
            person=new Person();
        else
            person = personService.getById(id);

        Contact contact=person.getContact();
        if (contact==null){
            contact=new Contact();
            contact.setPerson(person);
        }
        List<Country> countrys=countryService.listAll();
        modelAndView.addObject("person", person);
        modelAndView.addObject("persons", personService.listAll());
        modelAndView.addObject("contact", contact);
        modelAndView.addObject("countrys", countrys);
        modelAndView.setViewName("editPerson");
        Calendar calendars = Calendar.getInstance();
        modelAndView.addObject("calendars", calendars);
        return modelAndView;

    }

    @PostMapping(value = "/editPerson/save" )
    public ModelAndView save(@Valid Person person , BindingResult bindingResult , ModelAndView modelAndView) {
        modelAndView.addObject("person", person);
        personService.saveOrUpdate(person);
        return getPersonById( person.getId(),new ModelAndView());
    }

    @PostMapping("editPerson")
    public ModelAndView createPerson(@Valid Person person, BindingResult result) {
        personService.saveOrUpdate(person);
        return new ModelAndView();
    }

    @Secured("ADMIN")
    @GetMapping("/editPerson/delete/id/{id}")
    public String delete(@PathVariable Long id, ModelAndView modelAndView) {
        Person person;
        if (personService.existPerson(id))
            personService.delete(id);

        return "redirect:/welcome";

    }
    @PostMapping(Pages.VIEW_WELCOME)
    public String newPerson(@Valid Person person, BindingResult bindingResult, ModelAndView modelAndView) {
        modelAndView.setViewName("welcome");
        personService.saveOrUpdate(person);
        modelAndView.addObject("successMessage", "Person " + person.getFirstName() + " " + person.getLastName() + "has been saved successfully");
        return "redirect:/welcome";
    }



}
