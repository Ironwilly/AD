package com.salesianos.triana.E08_Herencia.services;


import com.salesianos.triana.E08_Herencia.model.Pedido;
import com.salesianos.triana.E08_Herencia.repositorios.PedidoRepo;
import com.salesianos.triana.E08_Herencia.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public abstract class PedidoService extends BaseService<Pedido,Long, PedidoRepo> {
}
