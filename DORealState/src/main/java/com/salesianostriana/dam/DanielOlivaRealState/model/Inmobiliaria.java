package com.salesianostriana.dam.DanielOlivaRealState.model;

import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@NamedEntityGraph(
        name = Inmobiliaria.INMOBILIARIA_CON_VIVIENDA,
        attributeNodes = {
                @NamedAttributeNode("viviendas")
        }
)
public class Inmobiliaria implements Serializable {

    public static final String INMOBILIARIA_CON_VIVIENDA= "grafo-inmobiliaria-con-vivienda";

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, email;

    private String telefono;

    @OneToMany(mappedBy = "inmobiliaria")
    private List<Vivienda> viviendas =new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "inmobiliaria",fetch = FetchType.EAGER)
    private List<Usuario> gestores=new ArrayList<>();

    public Inmobiliaria(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public Inmobiliaria(String nombre, String email, String telefono, List<Vivienda> viviendas) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.viviendas = viviendas;
    }

    @PreRemove
    public void preRemove() {
        viviendas.forEach( v -> v.setInmobiliaria(null));
    }
}
