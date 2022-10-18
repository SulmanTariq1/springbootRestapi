package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person person)
    {
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> GetPersons()
    {
        return personService.getPerson();
    }
    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id)
    {
        personService.removePersonById(id);
    }
    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") UUID id,@RequestBody Person person)
    {
        personService.updatePersonById(id,person);
    }
    @GetMapping(path = "{id}")
    public Person SelectPersonByID(@PathVariable("id") UUID id)
    {
        return personService.SelectPersonByID(id).orElse(null);
    }
}
