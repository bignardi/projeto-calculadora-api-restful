package com.vbt.projetocalculadora.services;

import com.vbt.projetocalculadora.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private Person person = new Person();
    private final AtomicLong counter = new AtomicLong();

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name: " + i);
        person.setLastName("Last name: " + i);
        person.setAddress("Address: " + i);
        person.setGender("Gender: " + i);
        return person;
    }

    public Person findById(String id) {
        person.setId(counter.incrementAndGet());
        person.setFirstName("Vinicius");
        person.setLastName("Bignardi");
        person.setAddress("Sorocaba/SP");
        person.setGender("Male");
        return person;
    }

    public Person insert(Person person) {
        return person;
    }

    public Person update(Person person) {
        return person;
    }

    public void delete(String id) {

    }

}
