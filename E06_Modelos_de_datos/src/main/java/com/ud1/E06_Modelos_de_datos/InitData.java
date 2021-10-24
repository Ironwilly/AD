package com.ud1.E06_Modelos_de_datos;


import com.ud1.E06_Modelos_de_datos.modelo.Producto;
import com.ud1.E06_Modelos_de_datos.servicios.CategoriaServicio;
import com.ud1.E06_Modelos_de_datos.servicios.ProductoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {


    private final ProductoServicio productoServicio;
    private final CategoriaServicio categoriaServicio;

            @PostConstruct
    public  void  init(){

                productoServicio.save(new Producto("Naranja","1€"));
                productoServicio.save(new Producto("Manzanas","2€"));
                productoServicio.save(new Producto("Uvas","3€"));


            }
}
