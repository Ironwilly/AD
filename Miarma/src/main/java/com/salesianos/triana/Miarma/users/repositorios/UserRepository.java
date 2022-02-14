package com.salesianos.triana.Miarma.users.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;


import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {





    Optional<User> findById(UUID id);
}