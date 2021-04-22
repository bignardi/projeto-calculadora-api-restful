package com.vbt.projetocalculadora.services;

import com.vbt.projetocalculadora.domain.model.Person;
import com.vbt.projetocalculadora.domain.vo.v3.PersonV3;
import com.vbt.projetocalculadora.repositories.PersonRepository;
import com.vbt.projetocalculadora.services.exception.ResourceNotFoundException;
import com.vbt.projetocalculadora.converters.adapter.DozerConverter;
import com.vbt.projetocalculadora.converters.custom.PersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonConverter converter;

    // V1, e v2 descontinuados. Lembrar de ajustar as versões nos pacotes.
    /*
    public List<PersonV1> findAll() {
        return repository.findAll();
    }

    public List<PersonV2> findAllV2() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonV2.class);
    }

    public PersonV1 findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));
        return DozerConverter.parseObject(entity, PersonV1.class);
    }

    public PersonV1 insert(PersonV1 person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonV1.class);
        return vo;
    }

    // Segunda versão do endpoint
    public PersonV2 insertV2(PersonV2 person) {
        var entity = converter.convertVOToEntity(person);
        var vo = converter.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public PersonV1 update(PersonV1 person) {
        var entity =  repository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(repository.save(entity), PersonV1.class);
        return vo;
    }

    public void delete(Long id) {
        Person entity =  repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));
         repository.delete(entity);
    }
    */

    // -> Versão 3:

    public List<PersonV3> findAllV3() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonV3.class);
    }

    public PersonV3 findByIdV3(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));
        return DozerConverter.parseObject(entity, PersonV3.class);
    }

    public PersonV3 insertV3(PersonV3 person) {
        var entity = converter.convertVOToEntity(person);
        var vo = converter.convertEntityToVO(repository.save(entity));
        return vo;
    }

    public PersonV3 updateV3(PersonV3 person) {
        var entity =  repository.findById(person.getKey()).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        person.setBirthday(person.getBirthday());

        var vo = DozerConverter.parseObject(repository.save(entity), PersonV3.class);
        return vo;
    }

    public void deleteV3(Long id) {
        Person entity =  repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));
        repository.delete(entity);
    }
    
}
