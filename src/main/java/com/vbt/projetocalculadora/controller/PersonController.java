package com.vbt.projetocalculadora.controller;

import com.vbt.projetocalculadora.domain.vo.v3.PersonV3;
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

    // V1, e v2 descontinuados. Lembrar de ajustar as versões nos pacotes.
    /*
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
        return service.update(person);
    }

    @DeleteMapping(value = "/v1/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    */

    // -> Versão 3:

    @GetMapping(value = "/v3", produces = {"application/json", "application/xml"})
    public List<PersonV3> findAllV3() {
        return service.findAllV3();
    }

    @GetMapping(value = "/v3/{id}", produces = {"application/json", "application/xml"})
    public PersonV3 findByIdV3(@PathVariable("id") Long id) {
        return service.findByIdV3(id);
    }

    @PostMapping(value = "/v3", produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"})
    public PersonV3 insertV3(@RequestBody PersonV3 person) {
        return service.insertV3(person);
    }

    @PutMapping(value = "/v3", produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"})
    public PersonV3 updateV3(@RequestBody PersonV3 person) {
        return service.updateV3(person);
    }

    @DeleteMapping(value = "/v3/{id}")
    public ResponseEntity<Void> deleteV3(@PathVariable("id") Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteV3(id);
        return ResponseEntity.ok().build();
    }

}
