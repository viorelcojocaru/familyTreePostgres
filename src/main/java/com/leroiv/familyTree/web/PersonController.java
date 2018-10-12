package com.leroiv.familyTree.web;

import com.leroiv.familyTree.domain.Contact;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Calendar;

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
        modelAndView.addObject("person", person);
        modelAndView.addObject("persons", personService.listAll());
        modelAndView.addObject("contact", contact);
        modelAndView.setViewName("editPerson");
        Calendar calendars = Calendar.getInstance();
        modelAndView.addObject("calendars", calendars);
        return modelAndView;

    }

    @PostMapping(value = "/editPerson/save" )
    public ModelAndView save(@Valid Person person , BindingResult bindingResult , ModelAndView modelAndView) {
        modelAndView.addObject("person", person);
        personService.saveOrUpdate(person);
        return edit( person.getId(),new ModelAndView());
    }


   /* @GetMapping("create-person")
    public ModelAndView createUserView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPerson");
        modelAndView.addObject("newPerson", new Person());
        modelAndView.addObject("persons", personService.listAll());
        return modelAndView;
    }*/

    @PostMapping("editPerson")
    public ModelAndView createPerson(@Valid Person person, BindingResult result) {
        personService.saveOrUpdate(person);
        return new ModelAndView();
    }
    @Autowired
    UserController userController;
    @Secured("ADMIN")
    @GetMapping("/editPerson/delete/id/{id}")
    public ModelAndView delete(@PathVariable Long id, ModelAndView modelAndView) {
        Person person;
        if (personService.existPerson(id))
            personService.delete(id);
        modelAndView.setViewName("/welcome");
        return userController.welcome(modelAndView);

    }

}
