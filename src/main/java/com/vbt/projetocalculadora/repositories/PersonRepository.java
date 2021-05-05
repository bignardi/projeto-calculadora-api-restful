package com.vbt.projetocalculadora.repositories;

import com.vbt.projetocalculadora.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Modifying
    @Query("UPDATE Person obj " +
            "SET obj.enabled = false " +
            "WHERE obj.id =:id")
    void disablePerson(@Param("id") Long id);

}
