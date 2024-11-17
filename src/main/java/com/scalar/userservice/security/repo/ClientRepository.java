package com.scalar.userservice.security.repo;


import java.util.Optional;


import com.scalar.userservice.security.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<com.scalar.userservice.security.models.Client, String> {
    Optional<com.scalar.userservice.security.models.Client> findByClientId(String clientId);
}