package com.salesianos.triana.Miarma.users.repositorios;

import com.salesianos.triana.Miarma.users.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<com.salesianos.triana.Miarma.users.model.User, UUID> {

    List<com.salesianos.triana.Miarma.users.model.User> findByRol (Roles rol);
    Optional<com.salesianos.triana.Miarma.users.model.User> findById(UUID id);
    Optional<User> findFirstByEmail(String email);

}