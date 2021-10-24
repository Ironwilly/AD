package com.ud1.E06_Modelos_de_datos.servicios;


import com.ud1.E06_Modelos_de_datos.modelo.Producto;
import com.ud1.E06_Modelos_de_datos.repositorios.ProductoRepository;
import com.ud1.E06_Modelos_de_datos.servicios.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio extends BaseService<Producto,Long, ProductoRepository> {


    public ProductoServicio(ProductoRepository repo){
        super(repo);
    }




}

