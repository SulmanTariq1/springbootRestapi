package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person)
    {
        return personDao.addPerson(person);
    }
    public List<Person> getPerson()
    {
        return personDao.getAllPerson();
    }
    public int removePersonById(UUID id)
    {
        personDao.DeletePersonById(id);
        return 1;
    }
    public int updatePersonById(UUID id,Person person)
    {
        personDao.updatePersonById(id,person);
        return 1;
    }
    public Optional<Person> SelectPersonByID(UUID id)
    {
        return personDao.SelectPersonByID(id);
    }
}
