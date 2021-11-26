package com.salesianostriana.dam.DanielOlivaRealState.usuarios.repos;

import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.RolUsuario;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findFirstByEmail(String email);
    Optional<Usuario> findById(UUID id);
    /*
    List<Usuario> findByRoles (RolUsuario roles);


     */
}
