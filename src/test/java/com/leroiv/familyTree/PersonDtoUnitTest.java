package com.leroiv.familyTree;

import com.leroiv.familyTree.domain.Person;
import com.leroiv.familyTree.domain.PersonDto;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class PersonDtoUnitTest {
    private ModelMapper modelMapper = new ModelMapper();
    private final SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
    @Test
    public void whenConvertPersonEntityToPersonDto_thenCorrect() throws ParseException {
        Person person = new Person();
        person.setId(Long.valueOf(1));
        person.setGender(10);
        person.setFirstName("Olga");
        person.setLastName("Barisova");
        person.setLastNameOnBirth("Bon");
        person.setBirthDate(simpleDateFormat.parse("1961-04-10"));

        PersonDto personDto = modelMapper.map(person, PersonDto.class);

        Assert.assertEquals(person.getId(), personDto.getId());

    }

    @Test
    public void whenConvertPersonDtoToPersonEntity_thenCorrect() throws ParseException {
        PersonDto personDto = new PersonDto();
        personDto.setId(Long.valueOf(1));
        personDto.setFirstName("Olga");
        personDto.setLastName("Barisova");
        personDto.setLastNameOnBirth("Bon");
        personDto.setBirthDate(simpleDateFormat.parse("1961-04-10"));

        Person person = modelMapper.map(personDto, Person.class);
         Assert.assertEquals(personDto.getId(), person.getId());
         Assert.assertEquals(personDto.getFirstName(), person.getFirstName());
         Assert.assertEquals(personDto.getLastName(), person.getLastName());
    }
}
