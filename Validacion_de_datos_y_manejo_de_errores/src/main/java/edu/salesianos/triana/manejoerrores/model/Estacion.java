package edu.salesianos.triana.manejoerrores.model;


import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Estacion implements Serializable {

    @Id
    @GeneratedValue
    private Long id;


    @NotBlank(message = "{estacion.nombre.blank}")
    @NotEmpty(message = "{estacion.nombre.empty}")
    @NotNull(message = "{estacion.nombre.null}")
    private String nombre;

    @NotNull(message = "{estacion.marca.null}")
    private String marca;

    @NotNull(message = "{estacion.ubicacion.null}")
    private String ubicacion;

    private Boolean tieneAutolavado = false;

    @NotNull(message = "{estacion.precioGasoilNormal.null}")
    @Min(value = 0, message = "{estacion.precioGasoilNormal.min}")
    private double precioGasoilNormal;

    @NotNull(message = "{estacion.precioGasolina95Octanos.null}")
    @Min(value = 0, message = "{estacion.precioGasolina95Octanos.min}")
    private double precioGasolina95Octanos;

    @Min(value = 0, message = "{estacion.precioGasoilEspecial.min}")
    private double precioGasoilEspecial;

    @Min(value = 0, message = "{estacion.precioGasolina98.min}")
    private double precioGasolina98;

    @Lob
    private String servicios;


    @CreatedDate
    @Past
    private LocalDate fechaApertura;

    @CreatedDate
    private LocalDate fechaRegistro;

    public Estacion(String nombre, String marca, String ubicacion, Boolean tieneAutolavado,
                     double precioGasolina95Octanos,
                    double precioGasoilEspecial, double precioGasolina98, String servicios,
                    LocalDate fechaApertura) {
        this.nombre = nombre;
        this.marca = marca;
        this.ubicacion = ubicacion;
        this.tieneAutolavado = tieneAutolavado;
        this.precioGasolina95Octanos = precioGasolina95Octanos;
        this.precioGasoilEspecial = precioGasoilEspecial;
        this.precioGasolina98 = precioGasolina98;
        this.servicios = servicios;
        this.fechaApertura = fechaApertura;

    }


}




