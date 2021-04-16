package com.vbt.projetocalculadora.util.converters.custom;

import com.vbt.projetocalculadora.domain.model.Person;
import com.vbt.projetocalculadora.domain.vo.v2.PersonV2;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class PersonConverter {

    public PersonV2 convertEntityToVO(Person person) {
        PersonV2 vo = new PersonV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthday(new Date());
        return vo;
    }

    public Person convertVOToEntity(PersonV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }

}
