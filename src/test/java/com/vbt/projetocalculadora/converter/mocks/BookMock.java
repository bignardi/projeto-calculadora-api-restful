package com.vbt.projetocalculadora.converter.mocks;

import com.vbt.projetocalculadora.domain.model.Book;
import com.vbt.projetocalculadora.domain.vo.v1.BookV1;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class BookMock {

    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookV1 mockVO() {
        return mockVO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookV1> mockVOList() {
        List<BookV1> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockVO(i));
        }
        return books;
    }

    private Book mockEntity(Integer number) {
        Book book = new Book();
        book.setAuthor("Author Test" + number);
        book.setTitle("Title Test" + number);
        book.setId(number.longValue());
        book.setLaunch_date(Instant.now());
        book.setPrice(number.doubleValue());
        return book;
    }

    private BookV1 mockVO(Integer number) {
        BookV1 book = new BookV1();
        book.setAuthor("Author Test" + number);
        book.setTitle("Title Test" + number);
        book.setKey(number.longValue());
        book.setLaunch_date(Instant.now());
        book.setPrice(number.doubleValue());
        return book;
    }

}
