package com.vbt.projetocalculadora.repositories;

import com.vbt.projetocalculadora.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT obj " +
            "FROM User obj " +
            "WHERE obj.userName =:userName")
    User findByUsername(@Param("userName") String userName);

}
