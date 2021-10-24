package com.ud1.E06_Modelos_de_datos.servicios.base;

import org.hibernate.annotations.ParamDef;

import java.util.List;

public interface IBaseService <T, ID{


    T save(T t);
    T findById(ID id);
    List<T> findAll();
    T edit(T t);
    void delete(T t);
    void deleteById(ID id);



}
