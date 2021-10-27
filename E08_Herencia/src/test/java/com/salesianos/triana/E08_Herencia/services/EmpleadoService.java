package com.salesianos.triana.E08_Herencia.services;

import com.salesianos.triana.E08_Herencia.model.Empleado;
import com.salesianos.triana.E08_Herencia.repositorios.EmpleadoRepo;
import com.salesianos.triana.E08_Herencia.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService extends BaseService<Empleado,Long, EmpleadoRepo> {
}
