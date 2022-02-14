package com.salesianos.triana.Miarma.users.services;


import com.salesianos.triana.Miarma.services.base.BaseService;
import com.salesianos.triana.Miarma.users.dto.CreateUserDto;
import com.salesianos.triana.Miarma.users.dto.GetUserDto;
import com.salesianos.triana.Miarma.users.dto.UserDtoConverter;
import com.salesianos.triana.Miarma.users.model.User;
import com.salesianos.triana.Miarma.users.repositorios.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service("userDetailService")
public class UserService extends BaseService<User, UUID, UserRepository> implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserDtoConverter userDtoConverter;


    public User saveUser(CreateUserDto createUserDto) {

        if (createUserDto.getPassword().contentEquals(createUserDto.getPassword2())) {
            User user = User.builder()
                    .nombre(createUserDto.getNombre())
                    .apellidos(createUserDto.getApellidos())
                    .direccion(createUserDto.getDireccion())
                    .email(createUserDto.getEmail())
                    .telefono(createUserDto.getTelefono())
                    .avatar(createUserDto.getAvatar())
                    .password(passwordEncoder.encode(createUserDto.getPassword()))
                    .build();

            return save(user);
        } else {
            return null;
        }


    }




    public List<GetUserDto> listUserToListGetUserDto(List<User> users) {
        List<GetUserDto> getUserDtos = new ArrayList<>();
        users.stream().forEach(u -> {
            getUserDtos.add(userDtoConverter.userToGetUserDto(u));
        });
        return getUserDtos;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

