package com.vbt.projetocalculadora.controller;

import com.vbt.projetocalculadora.domain.vo.v1.PersonV1;
import com.vbt.projetocalculadora.domain.vo.v2.PersonV2;
import com.vbt.projetocalculadora.repositories.PersonRepository;
import com.vbt.projetocalculadora.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class MathController {

    // Injeção de Dependência
    @Autowired
    private PersonService service;

    @Autowired
    private PersonRepository repository;

    // Será descontinuada em...
    @GetMapping("/v1")
    public List<PersonV1> findAll() {
        return service.findAll ();
    }

    @GetMapping("/v2")
    public List<PersonV2> findAllV2() {
        return service.findAllV2();
    }

    @GetMapping(value = "/v1/{id}")
    public PersonV1 findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    // Será descontinuada em...
    @PostMapping("/v1")
    public PersonV1 insert(@RequestBody PersonV1 person) {
        return service.insert(person);
    }

    @PostMapping("/v2")
    public PersonV2 insertV2(@RequestBody PersonV2 person) {
        return service.insertV2(person);
    }

    @PutMapping("/v1")
    public PersonV1 update(@RequestBody PersonV1 person) {
        return service.insert(person);
    }

    @DeleteMapping(value = "/v1/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
