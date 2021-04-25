package com.vbt.projetocalculadora.converter;

import com.vbt.projetocalculadora.converter.mocks.PersonMock;
import com.vbt.projetocalculadora.converters.adapter.DozerConverter;
import com.vbt.projetocalculadora.domain.model.Person;
import com.vbt.projetocalculadora.domain.vo.v3.PersonV3;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.TestInstance.Lifecycle.*;

/**
 * @apiNote
 * Classe responsável por testes automatizados da entidade Person
 * Efetua as conversões de Person para PersonVO
 */

@TestInstance(PER_CLASS)
public class DozerConverterPersonTest {

    // Obj de entrada
    PersonMock inputObject;

    @BeforeAll
    public void setUp() {
        inputObject = new PersonMock();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonV3 output = DozerConverter.parseObject(inputObject.mockEntity(), PersonV3.class);
        Assertions.assertEquals(Long.valueOf(0L), output.getKey());
        Assertions.assertEquals("First Name Test0", output.getFirstName());
        Assertions.assertEquals("Last Name Test0", output.getLastName());
        Assertions.assertEquals("Addres Test0", output.getAddress());
        Assertions.assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonV3> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonV3.class);
        PersonV3 outputZero = outputList.get(0);

        Assertions.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assertions.assertEquals("First Name Test0", outputZero.getFirstName());
        Assertions.assertEquals("Last Name Test0", outputZero.getLastName());
        Assertions.assertEquals("Addres Test0", outputZero.getAddress());
        Assertions.assertEquals("Male", outputZero.getGender());

        PersonV3 outputSeven = outputList.get(7);

        Assertions.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assertions.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assertions.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assertions.assertEquals("Addres Test7", outputSeven.getAddress());
        Assertions.assertEquals("Female", outputSeven.getGender());

        PersonV3 outputTwelve = outputList.get(12);

        Assertions.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assertions.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assertions.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assertions.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assertions.assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
        Assertions.assertEquals(Long.valueOf(0L), output.getId());
        Assertions.assertEquals("First Name Test0", output.getFirstName());
        Assertions.assertEquals("Last Name Test0", output.getLastName());
        Assertions.assertEquals("Addres Test0", output.getAddress());
        Assertions.assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
        Person outputZero = outputList.get(0);

        Assertions.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assertions.assertEquals("First Name Test0", outputZero.getFirstName());
        Assertions.assertEquals("Last Name Test0", outputZero.getLastName());
        Assertions.assertEquals("Addres Test0", outputZero.getAddress());
        Assertions.assertEquals("Male", outputZero.getGender());

        Person outputSeven = outputList.get(7);

        Assertions.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assertions.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assertions.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assertions.assertEquals("Addres Test7", outputSeven.getAddress());
        Assertions.assertEquals("Female", outputSeven.getGender());

        Person outputTwelve = outputList.get(12);

        Assertions.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assertions.assertEquals("First Name Test12", outputTwelve.getFirstName());
        Assertions.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assertions.assertEquals("Addres Test12", outputTwelve.getAddress());
        Assertions.assertEquals("Male", outputTwelve.getGender());
    }

}
