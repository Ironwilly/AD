package edu.salesianos.triana.RealStateV2.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private String avatar;
    private String password;
    private Enum rol;

    @Builder.Default
    @OneToMany(mappedBy = "vivienda")
    private List<Interesa> listInteresa = new ArrayList<>();

}
