package com.vbt.projetocalculadora.services;

import com.vbt.projetocalculadora.domain.model.Person;
import com.vbt.projetocalculadora.domain.vo.PersonVO;
import com.vbt.projetocalculadora.repositories.PersonRepository;
import com.vbt.projetocalculadora.services.exception.ResourceNotFoundException;
import com.vbt.projetocalculadora.util.converters.DozerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<PersonVO> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO insert(PersonVO person) {
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person) {
        var entity =  repository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        Person entity =  repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));
         repository.delete(entity);
    }

}
