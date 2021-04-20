package com.vbt.projetocalculadora.util.converters.custom;

import com.vbt.projetocalculadora.domain.model.Person;
import com.vbt.projetocalculadora.domain.vo.v3.PersonV3;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class PersonConverter {

    public PersonV3 convertEntityToVO(Person person) {
        PersonV3 vo = new PersonV3();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthday(new Date());
        return vo;
    }

    public Person convertVOToEntity(PersonV3 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }

}
