package com.salesianos.triana.E08_Herencia.repositorios;

import com.salesianos.triana.E08_Herencia.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepo extends JpaRepository<Pedido,Long> {
}
