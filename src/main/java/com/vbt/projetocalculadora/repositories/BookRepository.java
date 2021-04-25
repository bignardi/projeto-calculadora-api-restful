package com.vbt.projetocalculadora.repositories;

import com.vbt.projetocalculadora.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
