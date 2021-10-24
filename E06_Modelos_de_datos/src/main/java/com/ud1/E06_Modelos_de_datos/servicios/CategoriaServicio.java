package com.ud1.E06_Modelos_de_datos.servicios;


import com.ud1.E06_Modelos_de_datos.modelo.Categoria;
import com.ud1.E06_Modelos_de_datos.repositorios.CategoriaRepository;
import com.ud1.E06_Modelos_de_datos.servicios.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicio extends BaseService<Categoria,Long, CategoriaRepository>{

    public CategoriaServicio(CategoriaRepository repo){
        super(repo);
    }


}
