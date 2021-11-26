package com.salesianostriana.dam.DanielOlivaRealState.model;

import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.RolUsuario;
import com.salesianostriana.dam.DanielOlivaRealState.usuarios.model.Usuario;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vivienda implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String titulo;
    @Lob
    private String descripcion;
    @Lob
    private String avatar;
    private String latlng;
    private String direccion;
    private String codigoPostal;
    private String poblacion;
    private String provincia;

    @Enumerated(EnumType.STRING)
    private TipoVivienda tipoVivienda;

    private double precio;
    private int numHabitaciones;
    private int numBanios;
    private double metrosCuadrados;
    private boolean tienePiscina;
    private boolean tieneAscensor;
    private boolean tieneGaraje;

    @ManyToOne
    @JoinColumn(name = "inmobiliaria")
    private Inmobiliaria inmobiliaria;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @Builder.Default
    @OneToMany(mappedBy = "vivienda", cascade = {CascadeType.REMOVE})
    private List<Interesa> interesas = new ArrayList<>();

    public Vivienda(Long id, String titulo, String descripcion, String avatar, String provincia, double precio, int numHabitaciones, int numBanios, double metrosCuadrados) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.avatar = avatar;
        this.provincia = provincia;
        this.precio = precio;
        this.numHabitaciones = numHabitaciones;
        this.numBanios = numBanios;
        this.metrosCuadrados = metrosCuadrados;
    }

    public void addPropietario(Usuario u) {

        if(u.getRol().equals(RolUsuario.PROPIETARIO)) this.usuario = u;
        if (u.getListaViviendas() == null)
            u.setListaViviendas(new ArrayList<>());
        u.getListaViviendas().add(this);
    }

    public void removePropietario(Usuario u) {
        if(u.getRol().equals(RolUsuario.PROPIETARIO)){
            u.getListaViviendas().remove(this);
            this.usuario = null;
        }

    }

    public void addInmobiliaria(Inmobiliaria i) {
        this.inmobiliaria = i;
        i.getViviendas().add(this);
    }

    public void removeInmobiliaria(Inmobiliaria i) {
        i.getViviendas().remove(this);
        this.inmobiliaria = null;
    }

}
