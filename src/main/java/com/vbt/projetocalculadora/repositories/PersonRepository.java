package com.vbt.projetocalculadora.repositories;

import com.vbt.projetocalculadora.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
