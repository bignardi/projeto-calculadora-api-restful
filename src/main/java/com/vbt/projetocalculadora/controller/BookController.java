package com.vbt.projetocalculadora.controller;

import com.vbt.projetocalculadora.domain.vo.v1.BookV1;
import com.vbt.projetocalculadora.repositories.BookRepository;
import com.vbt.projetocalculadora.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

@Api(value = "Book Endpoint", description = "Description for Book", tags = {"Book Endpoint"})
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private BookRepository repository;

    @ApiOperation(value = "Find All")
    @GetMapping(value = "/v1",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<BookV1> findAll() {
        List<BookV1> bookV1 = service.findAll();
        bookV1.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
        return bookV1;
    }

    @ApiOperation(value = "Find By ID")
    @GetMapping(value = "/v1/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public BookV1 findById(@PathVariable("id") Long id) {
        BookV1 bookV1 = service.findById(id);
        bookV1.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
        return bookV1;
    }

    @ApiOperation(value = "Create Person")
    @PostMapping(value = "/v1",
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BookV1 insert(@RequestBody BookV1 book) {
        BookV1 bookV1 = service.insert(book);
        bookV1.add(linkTo(methodOn(BookController.class).findById(bookV1.getKey())).withSelfRel());
        return bookV1;
    }

    @ApiOperation(value = "Update Person")
    @PutMapping(value = "/v1",
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public BookV1 update(@RequestBody BookV1 book) {
        BookV1 bookV1 = service.update(book);
        bookV1.add(linkTo(methodOn(BookController.class).findById(bookV1.getKey())).withSelfRel());
        return bookV1;
    }

    @ApiOperation(value = "Delete By ID")
    @DeleteMapping(value = "/v1/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
