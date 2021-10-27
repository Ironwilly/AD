package com.salesianos.triana.E08_Herencia.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ClienteParticular extends Cliente implements Serializable {

    private LocalDate fechaParticular;

    public ClienteParticular(String nombre, String apellidos,
                             String dni, String email, String telefono, LocalDate fechaParticular) {
        super(nombre, apellidos, dni, email, telefono);
        this.fechaParticular = fechaParticular;
    }
}
