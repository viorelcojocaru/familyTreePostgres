package com.leroiv.familyTree.web;

import com.leroiv.familyTree.domain.Contact;
import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.service.ContactService;
import com.leroiv.familyTree.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class ContactController {

    private final CountryService countryService;

    private final ContactService contactService;

    @Autowired
    private PersonController personController;

    @PostMapping("/editPersonContactSave")
    public ModelAndView savePerson(@Valid Contact contact, BindingResult result) {
        contactService.saveOrUpdate(contact);
        return personController.edit(contact.getPerson().getId(), new ModelAndView());
    }

}
