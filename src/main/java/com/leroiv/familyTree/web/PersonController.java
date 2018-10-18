package com.leroiv.familyTree.web;

import com.leroiv.familyTree.BC.AccountBC;
import com.leroiv.familyTree.constants.AppAccountTypes;
import com.leroiv.familyTree.constants.Genders;
import com.leroiv.familyTree.constants.Pages;
import com.leroiv.familyTree.controller.ResourceNotFoundException;
import com.leroiv.familyTree.domain.*;
import com.leroiv.familyTree.service.AppAccountService;
import com.leroiv.familyTree.service.AppAccountTypeService;
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
    private final AppAccountService appAccountService;
    private final AppAccountTypeService appAccountTypeService;

    @GetMapping("/editPerson/id/{id}")
    public ModelAndView getPersonById(@PathVariable Long id, ModelAndView modelAndView) {
        modelAndView = buildPersonModelAndView(id, modelAndView);
        modelAndView.setViewName("editPerson");
        return modelAndView;
    }

    private ModelAndView buildPersonModelAndView(Long id, ModelAndView modelAndView) {
        Person person;
        if (id == 0)
            person = new Person();
        else {
            if (!personService.existPerson(id))
                throw new ResourceNotFoundException("not found person with id:" + id);
            person = personService.getById(id);
        }
        Contact contact = person.getContact();
        if (contact == null) {
            contact = new Contact();
            contact.setPerson(person);
        }
        List<Country> countrys = countryService.listAll();

        modelAndView.addObject("person", person);
        modelAndView.addObject("persons", personService.listAll());
        modelAndView.addObject("contact", contact);
        modelAndView.addObject("countrys", countrys);
        Calendar calendars = Calendar.getInstance();
        modelAndView.addObject("calendars", calendars);
        return modelAndView;
    }

    @GetMapping("/viewPerson/id/{id}")
    public ModelAndView getViewPersonById(@PathVariable Long id, ModelAndView modelAndView) {
        modelAndView = buildPersonModelAndView(id, modelAndView);
        modelAndView.setViewName("viewPerson");
        return modelAndView;
    }

    @PostMapping(value = "/editPerson/save")
    public ModelAndView save(@Valid Person person, Person source, Long typeId, BindingResult bindingResult, ModelAndView modelAndView) {

        if (source != null) {
            personService.saveOrUpdate(person);
            AppAccount currentAppAcc = AccountBC.getInstance().createAppAccount(person, appAccountTypeService.getById(typeId));
            appAccountService.saveOrUpdate(currentAppAcc);
            AppAccount appAccountFrom = null;
            AppAccount appAccountTo = null;

            if (person.getGender() == Genders.FEMALE) {
                appAccountFrom = currentAppAcc;
                appAccountTo = appAccountService.getAppAccountBy(source.getId(), typeId);
            } else if (person.getGender() == Genders.MALE) {
                appAccountFrom = appAccountService.getAppAccountBy(source.getId(), typeId);
                appAccountTo = currentAppAcc;
            }
            try {
                AccountBC.getInstance().createRelation(appAccountFrom, appAccountTo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        modelAndView.addObject("person", person);
        modelAndView.setViewName("redirect:/viewPerson/id/" + person.getId());
        return modelAndView;
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

    @GetMapping("/viewPerson/id/{id}/addCild")
    public ModelAndView addCild(@PathVariable Long id, Long type, ModelAndView modelAndView) {
        if (personService.existPerson(id)) {
            modelAndView.addObject("source", personService.getById(id));
            modelAndView.addObject("type", AppAccountTypes.CILD);
            modelAndView.setViewName("redirect:/editPerson/id/0");

        } else
            modelAndView.setViewName("redirect:/welcome");

        return modelAndView;
    }
}
