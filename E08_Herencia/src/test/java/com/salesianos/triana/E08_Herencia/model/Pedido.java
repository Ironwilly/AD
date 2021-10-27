package com.salesianos.triana.E08_Herencia.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Pedido implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String numeroPedido;

    @ManyToOne
    @JoinColumn(name = "cliente",foreignKey = @ForeignKey(name = "FK_PEDIDO_CLIENTE" ))

    private Cliente c;
}
