package com.salesianostriana.dam.DanielOlivaRealState;

import com.salesianostriana.dam.DanielOlivaRealState.model.Inmobiliaria;
import com.salesianostriana.dam.DanielOlivaRealState.model.TipoVivienda;
import com.salesianostriana.dam.DanielOlivaRealState.model.Vivienda;
import com.salesianostriana.dam.DanielOlivaRealState.services.InmobiliariaService;
import com.salesianostriana.dam.DanielOlivaRealState.services.ViviendaService;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.dto.CreateUsuarioDto;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final UsuarioService usuarioService;
    private final ViviendaService viviendaService;
    private InmobiliariaService inmobiliariaService;

    @PostConstruct
    public void test() {

        CreateUsuarioDto admin1 = CreateUsuarioDto.builder()
                .nombre("Daniel")
                .apellidos("Oliva García")
                .avatar("danieloliva.jpg")
                .email("danieloliva@gmail.com")
                .username("danieloliva")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveAdmin(admin1);

        CreateUsuarioDto admin2 = CreateUsuarioDto.builder()
                .nombre("Jaime")
                .apellidos("Jiménez")
                .avatar("jaimejimenez.jpg")
                .email("jaimejimenez@gmail.com")
                .username("jaimejimenez")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveGestor(admin2);

        CreateUsuarioDto admin3 = CreateUsuarioDto.builder()
                .nombre("Jesús")
                .apellidos("Barco")
                .avatar("jasusbarco.png")
                .email("jesusbarco@gmail.com")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveGestor(admin3);

        CreateUsuarioDto admin4 = CreateUsuarioDto.builder()
                .nombre("Miguel")
                .apellidos("Campos")
                .avatar("miguelcampos.jpg")
                .email("miguelcampos@gmail.com")
                .username("miguelcampos")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveGestor(admin4);

        CreateUsuarioDto admin5 = CreateUsuarioDto.builder()
                .nombre("Luis Miguel")
                .apellidos("López")
                .avatar("lmlopez.png")
                .email("lmlopez@gmail.com")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveGestor(admin5);

        CreateUsuarioDto gestor1 = CreateUsuarioDto.builder()
                .nombre("Juana")
                .apellidos("Miranda")
                .avatar("juanamiranda.jpg")
                .email("juanamiranda@gmail.com")
                .username("juanamiranda")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveGestor(gestor1);

        CreateUsuarioDto gestor2 = CreateUsuarioDto.builder()
                .nombre("Edgar")
                .apellidos("González")
                .avatar("edgargonzalez.jpg")
                .email("edgargonzalez@gmail.com")
                .username("edgargonzalez")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveGestor(gestor2);

        CreateUsuarioDto gestor3 = CreateUsuarioDto.builder()
                .nombre("Hector")
                .apellidos("Bellerín")
                .avatar("hectorbellerin.jpg")
                .email("hectorbellerin@gmail.com")
                .username("hectorbellerin")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveGestor(gestor3);

        CreateUsuarioDto gestor4 = CreateUsuarioDto.builder()
                .nombre("Claudia")
                .apellidos("Bravo")
                .avatar("claudiabravo.jpg")
                .email("claudiabravo@gmail.com")
                .username("claudiabravo")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveGestor(gestor4);

        CreateUsuarioDto gestor5 = CreateUsuarioDto.builder()
                .nombre("Marc")
                .apellidos("Bartra")
                .avatar("marcbartra.jpg")
                .email("marcbartra@gmail.com")
                .username("marcbartra")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.saveGestor(gestor5);

        CreateUsuarioDto propietario1 = CreateUsuarioDto.builder()
                .nombre("Guido")
                .apellidos("Rodríguez")
                .avatar("guidorodriguez.png")
                .email("guidorodriguez@gmail.com")
                .username("guidorodriguez")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.savePropietario(propietario1);

        CreateUsuarioDto propietario2 = CreateUsuarioDto.builder()
                .nombre("Sergio")
                .apellidos("Canales")
                .avatar("sergiocanales.png")
                .email("sergiocanales@gmail.com")
                .username("sergiocanales")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.savePropietario(propietario2);

        CreateUsuarioDto propietario3 = CreateUsuarioDto.builder()
                .nombre("Joaquín")
                .apellidos("Sánchez")
                .avatar("joaquinsanchez.png")
                .email("joaquinsanchez@gmail.com")
                .username("joaquinsanchez")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.savePropietario(propietario3);

        CreateUsuarioDto propietario4 = CreateUsuarioDto.builder()
                .nombre("Roberto")
                .apellidos("González")
                .avatar("robertogonzalez.png")
                .email("robertogonzalez@gmail.com")
                .username("robertogonzalez")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.savePropietario(propietario4);

        CreateUsuarioDto propietario5 = CreateUsuarioDto.builder()
                .nombre("Cristina")
                .apellidos("Tello")
                .avatar("cristinatello.png")
                .email("cristinatello@gmail.com")
                .username("cristinatello")
                .password("12345678")
                .password2("12345678")
                .build();

        usuarioService.savePropietario(propietario5);

        Vivienda vivienda1 = Vivienda.builder()
                .titulo("Casa")
                .descripcion("Casa grande")
                .precio(234567.89)
                .tipoVivienda(TipoVivienda.VENTA)
                .build();

        viviendaService.save(vivienda1);

        Vivienda vivienda2 = Vivienda.builder()
                .titulo("Piso")
                .descripcion("Piso grande")
                .precio(204567.89)
                .tipoVivienda(TipoVivienda.VENTA)
                .build();

        viviendaService.save(vivienda2);

        Vivienda vivienda3 = Vivienda.builder()
                .titulo("Casa")
                .descripcion("Casa pequeña")
                .precio(500)
                .tipoVivienda(TipoVivienda.ALQUILER)
                .build();

        viviendaService.save(vivienda3);

        Vivienda vivienda4 = Vivienda.builder()
                .titulo("Piso")
                .descripcion("Piso pequeño")
                .precio(400)
                .tipoVivienda(TipoVivienda.ALQUILER)
                .build();

        viviendaService.save(vivienda4);

        Vivienda vivienda5 = Vivienda.builder()
                .titulo("Terreno")
                .descripcion("Terreno grande")
                .precio(334567.89)
                .tipoVivienda(TipoVivienda.OBRANUEVA)
                .build();

        viviendaService.save(vivienda5);

    }
}
