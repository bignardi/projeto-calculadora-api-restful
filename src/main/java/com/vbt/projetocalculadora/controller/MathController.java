package com.vbt.projetocalculadora.controller;

import com.vbt.projetocalculadora.model.Person;
import com.vbt.projetocalculadora.repositories.PersonRepository;
import com.vbt.projetocalculadora.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class MathController {

    // Injeção de Dependência
    @Autowired
    private PersonService service;

    @Autowired
    private PersonRepository repository;

    @GetMapping
    public List<Person> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") Long id) {
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
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
