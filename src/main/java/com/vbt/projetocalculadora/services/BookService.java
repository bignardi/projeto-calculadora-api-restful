package com.vbt.projetocalculadora.services;

import com.vbt.projetocalculadora.converters.adapter.DozerConverter;
import com.vbt.projetocalculadora.converters.custom.BookConverter;
import com.vbt.projetocalculadora.domain.model.Book;
import com.vbt.projetocalculadora.domain.vo.v1.BookV1;
import com.vbt.projetocalculadora.repositories.BookRepository;
import com.vbt.projetocalculadora.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookConverter converter;

    public List<BookV1> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), BookV1.class);
    }

    public BookV1 findById(Long id) {
        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("ID not found!"));
        return DozerConverter.parseObject(entity, BookV1.class);
    }

    public BookV1 insert(BookV1 bookV1) {
        var entity = converter.convertVOToEntity(bookV1);
        var vo = converter.convertEntityToVO(entity);
        return vo;
    }

    public BookV1 update(BookV1 bookV1) {
        var entity = repository.findById(bookV1.getKey()).orElseThrow(() ->
                new ResourceNotFoundException("Id not found!"));

        entity.setId(bookV1.getKey());
        entity.setAuthor(bookV1.getAuthor());
        entity.setLaunch_date(bookV1.getLaunch_date());
        entity.setPrice(bookV1.getPrice());
        entity.setTitle(bookV1.getTitle());

        var vo = DozerConverter.parseObject(repository.save(entity), BookV1.class);
        return vo;
    }

    public void delete(Long id) {
        Book entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Id not found!"));
        repository.delete(entity);
    }

}
