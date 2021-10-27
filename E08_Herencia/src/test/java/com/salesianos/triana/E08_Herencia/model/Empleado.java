package com.salesianos.triana.E08_Herencia.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
public class Empleado implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellidos;
    private String numEmpleado;
    private String tipoContrato;

    @OneToMany (mappedBy = "empleado")
    @Builder.Default
    private List<ClienteCorporativo> listCorp = new ArrayList<>();

    //métodos helpers

    public void addClienteCorporativo(ClienteCorporativo cc){
        this.listCorp.add(cc);
        cc.setEmpleado(this);
    }

    public void deleteClienteCoporativo(ClienteCorporativo cc){
        this.listCorp.remove(cc);
        cc.setEmpleado(null);
    }



}
