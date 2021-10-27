package com.salesianos.triana.E08_Herencia.services;


import com.salesianos.triana.E08_Herencia.model.Cliente;
import com.salesianos.triana.E08_Herencia.repositorios.ClienteRepo;
import com.salesianos.triana.E08_Herencia.services.base.BaseService;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class ClienteService extends BaseService<Cliente,Long, ClienteRepo> {



}
