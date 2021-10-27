package com.salesianos.triana.E08_Herencia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ClienteCorporativo extends Cliente{

    private LocalDate fechaCorporativo;

    @ManyToOne
    private Empleado empleado;

    public ClienteCorporativo(String nombre, String apellidos, String dni, String email, String telefono, LocalDate fechaCorporativo) {
        super(nombre, apellidos, dni, email, telefono);
        this.fechaCorporativo = fechaCorporativo;
    }
}
