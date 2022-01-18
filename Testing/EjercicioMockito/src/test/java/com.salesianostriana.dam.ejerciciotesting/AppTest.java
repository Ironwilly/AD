package com.salesianostriana.dam.ejerciciotesting;


import com.salesianostriana.dam.ejerciciotesting.model.Cliente;
import com.salesianostriana.dam.ejerciciotesting.model.LineaDeVenta;
import com.salesianostriana.dam.ejerciciotesting.model.Producto;
import com.salesianostriana.dam.ejerciciotesting.model.Venta;
import com.salesianostriana.dam.ejerciciotesting.repos.ProductoRepositorio;
import com.salesianostriana.dam.ejerciciotesting.repos.VentaRepositorio;
import com.salesianostriana.dam.ejerciciotesting.services.VentaServicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AppTest {


    @Mock
    VentaRepositorio ventaRepositorio;

    @Mock
    ProductoRepositorio productoRepositorio;

    @InjectMocks
    VentaServicio ventaServicio;

    //----------------------------------------------------------------

    //Probando caja negra

    //----------------------------------------------------------------

    @Test
    public void testNuevaVenta(){

        Cliente cliente1 = new Cliente();
        LineaDeVenta lineaDeVenta = new LineaDeVenta(new Producto("3452w","Colacao",5.65),2,5.65);
        List<LineaDeVenta> lineaDeVentaList = new ArrayList<>();
        lineaDeVentaList.add(lineaDeVenta);
        Venta venta1 = new Venta(1L, LocalDate.now(),lineaDeVentaList,cliente1);


        //desde aquí ya no se seguir, por mucho que leo el manual, no se como hacer la comparativa, se que con assertEquals, pero no se como compararlo con el servicio

    }


}
