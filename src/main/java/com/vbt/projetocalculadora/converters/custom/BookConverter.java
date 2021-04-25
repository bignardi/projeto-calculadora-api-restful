package com.vbt.projetocalculadora.converters.custom;

import com.vbt.projetocalculadora.domain.model.Book;
import com.vbt.projetocalculadora.domain.vo.v1.BookV1;
import org.springframework.stereotype.Service;

@Service
public class BookConverter {

    public BookV1 convertEntityToVO(Book entity) {
        BookV1 vo = new BookV1();
        vo.setKey(entity.getId());
        vo.setAuthor(entity.getAuthor());
        vo.setLaunch_date(entity.getLaunch_date());
        vo.setPrice(entity.getPrice());
        vo.setTitle(entity.getTitle());
        return vo;
    }

    public Book convertVOToEntity(BookV1 vo) {
        Book entity = new Book();
        entity.setId(vo.getKey());
        entity.setAuthor(vo.getAuthor());
        entity.setLaunch_date(vo.getLaunch_date());
        entity.setPrice(vo.getPrice());
        entity.setTitle(vo.getTitle());
        return entity;
    }

}