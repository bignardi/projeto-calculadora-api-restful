package com.vbt.projetocalculadora.converter;

import com.vbt.projetocalculadora.converter.mocks.BookMock;
import com.vbt.projetocalculadora.converters.adapter.DozerConverter;
import com.vbt.projetocalculadora.domain.model.Book;
import com.vbt.projetocalculadora.domain.vo.v1.BookV1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class DozerConverterBookTest {

    // Obj de entrada
    BookMock inputObject;

    @BeforeAll
    public void setUp() {
        inputObject = new BookMock();
    }

    @Test
    public void parseEntityToVOTest() {
        BookV1 output = DozerConverter.parseObject(inputObject.mockEntity(), BookV1.class);
        Assertions.assertEquals(Long.valueOf(0L), output.getKey());
        Assertions.assertEquals("Author Test0", output.getAuthor());
        Assertions.assertEquals("Title Test0", output.getTitle());
        Assertions.assertEquals("Lauch Date Test0", output.getLaunch_date());
        Assertions.assertEquals("Price Test0", output.getPrice());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<BookV1> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), BookV1.class);
        BookV1 outputZero = outputList.get(0);

        Assertions.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assertions.assertEquals("Author Test0", outputZero.getAuthor());
        Assertions.assertEquals("Title Test0", outputZero.getTitle());
        Assertions.assertEquals("Lauch Date Test0", outputZero.getLaunch_date());
        Assertions.assertEquals("Price Test0", outputZero.getPrice());

        BookV1 outputSeven = outputList.get(7);

        Assertions.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assertions.assertEquals("Author Test7", outputSeven.getAuthor());
        Assertions.assertEquals("Title Test7", outputSeven.getTitle());
        Assertions.assertEquals("Lauch Date Test7", outputSeven.getLaunch_date());
        Assertions.assertEquals("Price Test7", outputSeven.getPrice());

        BookV1 outputTwelve = outputList.get(12);

        Assertions.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assertions.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assertions.assertEquals("Title Test12", outputTwelve.getTitle());
        Assertions.assertEquals("Lauch Date Test12", outputTwelve.getLaunch_date());
        Assertions.assertEquals("Price Test12", outputTwelve.getPrice());
    }

    @Test
    public void parseVOToEntityTest() {
        Book output = DozerConverter.parseObject(inputObject.mockVO(), Book.class);
        Assertions.assertEquals(Long.valueOf(0L), output.getId());
        Assertions.assertEquals("Author Test0", output.getAuthor());
        Assertions.assertEquals("Title Test0", output.getTitle());
        Assertions.assertEquals("Lauch Date Test0", output.getLaunch_date());
        Assertions.assertEquals("Price Test0", output.getPrice());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Book> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Book.class);
        Book outputZero = outputList.get(0);

        Assertions.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assertions.assertEquals("Author Test0", outputZero.getAuthor());
        Assertions.assertEquals("Title Test0", outputZero.getTitle());
        Assertions.assertEquals("Lauch Date Test0", outputZero.getLaunch_date());
        Assertions.assertEquals("Price Test0", outputZero.getPrice());

        Book outputSeven = outputList.get(7);

        Assertions.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assertions.assertEquals("Author Test7", outputSeven.getAuthor());
        Assertions.assertEquals("Title Test7", outputSeven.getTitle());
        Assertions.assertEquals("Lauch Date Test7", outputSeven.getLaunch_date());
        Assertions.assertEquals("Price Test7", outputSeven.getPrice());

        Book outputTwelve = outputList.get(12);

        Assertions.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assertions.assertEquals("Author Test12", outputTwelve.getAuthor());
        Assertions.assertEquals("Title Test12", outputTwelve.getTitle());
        Assertions.assertEquals("Lauch Date Test12", outputTwelve.getLaunch_date());
        Assertions.assertEquals("Price Test12", outputTwelve.getPrice());
    }

}
