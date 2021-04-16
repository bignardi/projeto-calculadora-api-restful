package com.vbt.projetocalculadora.converter;

import com.vbt.projetocalculadora.converter.mocks.PersonMock;
import com.vbt.projetocalculadora.domain.model.Person;
import com.vbt.projetocalculadora.domain.vo.v1.PersonV1;
import com.vbt.projetocalculadora.util.converters.DozerConverter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.TestInstance.Lifecycle.*;

/**
 * @apiNote
 * Classe responsável por testes automatizados da entidade Person
 * Efetua as converesões de Person para PersonVO
 */

@TestInstance(PER_CLASS)
public class DozerConverterTest {

    // Obj de entrada
    PersonMock inputObject;

    @BeforeAll
    public void setUp() {
        inputObject = new PersonMock();
    }

    @Test
    public void parseEntityToVOTest() {
        PersonV1 output = DozerConverter.parseObject(inputObject.mockEntity(), PersonV1.class);
        Assertions.assertEquals(Long.valueOf(0L), output.getId());
        Assertions.assertEquals("First Name Test0", output.getFirstName());
        Assertions.assertEquals("Last Name Test0", output.getLastName());
        Assertions.assertEquals("Addres Test0", output.getAddress());
        Assertions.assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<PersonV1> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonV1.class);
        PersonV1 outputZero = outputList.get(0);

        Assertions.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assertions.assertEquals("First Name Test0", outputZero.getFirstName());
        Assertions.assertEquals("Last Name Test0", outputZero.getLastName());
        Assertions.assertEquals("Addres Test0", outputZero.getAddress());
        Assertions.assertEquals("Male", outputZero.getGender());

        PersonV1 outputSeven = outputList.get(7);

        Assertions.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assertions.assertEquals("First Name Test7", outputSeven.getFirstName());
        Assertions.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assertions.assertEquals("Addres Test7", outputSeven.getAddress());
        Assertions.assertEquals("Female", outputSeven.getGender());

        PersonV1 outputTwelve = outputList.get(12);

        Assertions.assertEquals(Long.valueOf(12L), outputTwelve.getId());
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
