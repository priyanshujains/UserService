package com.scalar.userservice.Repositories;

import com.scalar.userservice.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token,Long> {

    Token save(Token token);

    Optional<Token> findByValueAndDeletedEquals(String value, boolean isdel);

    Optional<Token> findByValueAndDeletedEqualsAndExpiryAtGreaterThan(String value, boolean isdel, Date today);
}
