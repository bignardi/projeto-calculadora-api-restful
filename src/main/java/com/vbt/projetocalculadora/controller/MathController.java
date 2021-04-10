package com.vbt.projetocalculadora.controller;

import com.vbt.projetocalculadora.controller.bo.MathBO;
import com.vbt.projetocalculadora.model.Person;
import com.vbt.projetocalculadora.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.vbt.projetocalculadora.exception.MathOperationException;

import java.util.List;

@RestController
@RequestMapping("/person")
public class MathController {

    // Injeção de Depenêrncia
    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person insert(@RequestBody Person person) {
        return service.insert(person);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return service.insert(person);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
