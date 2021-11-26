package com.salesianostriana.dam.DanielOlivaRealState.usuarios.services;

import com.salesianostriana.dam.DanielOlivaRealState.model.Inmobiliaria;
import com.salesianostriana.dam.DanielOlivaRealState.services.InmobiliariaService;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.dto.CreateUsuarioDto;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.RolUsuario;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.repos.UsuarioRepository;
import com.salesianostriana.dam.DanielOlivaRealState.services.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("userDetailsService")
@RequiredArgsConstructor
public class UsuarioService extends BaseService<Usuario, UUID, UsuarioRepository> implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final InmobiliariaService inmobiliariaService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return this.repositorio.findFirstByEmail(email).orElseThrow(()-> new UsernameNotFoundException(email + " no encontrado"));

    }
    /*
        public List<Usuario> loadUserByRol(RolUsuario roles) throws UsernameNotFoundException {
            return this.repositorio.findByRoles(roles);
        }
*/
        public Optional<Usuario> loadUserById(UUID id) throws UsernameNotFoundException {
            return this.repositorio.findById(id);
        }

    public Usuario saveAdmin(CreateUsuarioDto nuevoAdmin) {
        if (nuevoAdmin.getPassword().contentEquals(nuevoAdmin.getPassword2())) {
            Usuario usuario = Usuario.builder()
                    .password(passwordEncoder.encode(nuevoAdmin.getPassword()))
                    .avatar(nuevoAdmin.getAvatar())
                    .nombre(nuevoAdmin.getNombre())
                    .apellidos(nuevoAdmin.getApellidos())
                    .email(nuevoAdmin.getEmail())
                    .rol(RolUsuario.ADMIN)
                    .build();
            return save(usuario);
        } else {
            return null;
        }
    }

    public Usuario savePropietario(CreateUsuarioDto nuevoPropietario) {
        if (nuevoPropietario.getPassword().contentEquals(nuevoPropietario.getPassword2())) {
            Usuario usuario = Usuario.builder()
                    .password(passwordEncoder.encode(nuevoPropietario.getPassword()))
                    .avatar(nuevoPropietario.getAvatar())
                    .nombre(nuevoPropietario.getNombre())
                    .apellidos(nuevoPropietario.getApellidos())
                    .email(nuevoPropietario.getEmail())
                    .rol(RolUsuario.PROPIETARIO)
                    .build();
            return save(usuario);
        } else {
            return null;
        }
    }

    public Usuario saveGestor(CreateUsuarioDto nuevoGestor) {
        if (nuevoGestor.getPassword().contentEquals(nuevoGestor.getPassword2())) {
            Usuario usuario = Usuario.builder()
                    .password(passwordEncoder.encode(nuevoGestor.getPassword()))
                    .avatar(nuevoGestor.getAvatar())
                    .nombre(nuevoGestor.getNombre())
                    .apellidos(nuevoGestor.getApellidos())
                    .email(nuevoGestor.getEmail())
                    .rol(RolUsuario.GESTOR)
                    .build();
            return save(usuario);
        } else {
            return null;
        }
    }

    public Usuario saveGestorWithoutId(CreateUsuarioDto nuevoGestor, Inmobiliaria inmobiliaria) {

        if (nuevoGestor.getPassword().contentEquals(nuevoGestor.getPassword2())) {
            Usuario user = Usuario.builder()
                    .password(passwordEncoder.encode(nuevoGestor.getPassword()))
                    .avatar(nuevoGestor.getAvatar())
                    .apellidos(nuevoGestor.getApellidos())
                    .nombre(nuevoGestor.getNombre())
                    .email(nuevoGestor.getEmail())
                    .rol(RolUsuario.GESTOR)
                    .inmobiliaria(null)
                    .build();

            user.addInmobiliaria(inmobiliaria);
            try{
                return save(user);
            }catch (DataIntegrityViolationException ex){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de ese usuario ya existe");
            }
        } else {
            return null;
        }
    }

}
