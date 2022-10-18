package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> BD= new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        BD.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPerson() {
        return BD;
    }

    @Override
    public int DeletePersonById(UUID id) {
        Optional<Person> personMaybe= SelectPersonByID(id);
        if(personMaybe.isEmpty())
        {
            return 0;
        }
        BD.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return SelectPersonByID(id).map(p-> {
            int indexPfPerspmToUpdate= BD.indexOf(p);
            if(indexPfPerspmToUpdate>=0){
                BD.set(indexPfPerspmToUpdate, new Person(id, person.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> SelectPersonByID(UUID id) {
        return BD.stream().filter(person -> person.getId().equals(id)).findFirst();
    }
}
