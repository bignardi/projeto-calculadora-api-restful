package com.vbt.projetocalculadora.services;

import com.vbt.projetocalculadora.domain.model.Person;
import com.vbt.projetocalculadora.domain.vo.v1.PersonV1;
import com.vbt.projetocalculadora.domain.vo.v2.PersonV2;
import com.vbt.projetocalculadora.repositories.PersonRepository;
import com.vbt.projetocalculadora.services.exception.ResourceNotFoundException;
import com.vbt.projetocalculadora.util.converters.DozerConverter;
import com.vbt.projetocalculadora.util.converters.custom.PersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonConverter converter;

    public List<PersonV1> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonV1.class);
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

}
