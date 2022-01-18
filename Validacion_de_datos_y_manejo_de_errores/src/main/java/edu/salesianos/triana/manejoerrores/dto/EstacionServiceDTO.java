package edu.salesianos.triana.manejoerrores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstacionServiceDTO {
    @NotBlank(message = "{estacionService.nombre.blank}")
    @NotNull(message = "{estacionService.nombre.null}")
    private String nombre;

    @NotBlank(message = "{estacionService.marca.blank}")
    private String marca;

    @NotNull(message = "{estacionService.ubicacion.null}")
    private String ubicacion;

    private boolean tieneAutolavado;

    @NotNull(message = "{estacionService.precioGasoilNormal.null}")
    @Min(value = 0, message = "{estacionService.precio.min}")
    private double precioGasoilNormal;

    @NotNull(message = "{estacionService.precioGasolina95Octanos.null}")
    @Min(value = 0, message = "{estacionService.precio.min}")
    private double precioGasolina95Octanos;

    @Min(value = 0, message = "{estacionService.precio.min}")
    private double precioGasoilEspecial;

    @Min(value = 0, message = "{estacionService.precio.min}")
    private double precioGasolina98;

    private String servicios;

    private LocalDate fechaApertura;

    private LocalDate fechaRegistro;
}
