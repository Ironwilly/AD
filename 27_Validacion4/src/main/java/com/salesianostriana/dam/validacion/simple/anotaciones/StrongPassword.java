package com.salesianostriana.dam.validacion.simple.anotaciones;


import com.salesianostriana.dam.validacion.simple.validadores.StrongPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = StrongPasswordValidator.class)
@Documented
public @interface StrongPassword {

    String message() default "La contraseña no cumple con los requisitos de validación especificados";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int min() default 5;
    int max() default 15;
    boolean hasUpper() default false;
    boolean hasLower() default false;
    boolean hasNumber() default false;
    boolean hasAlpha() default false;
    boolean hasOthers() default false;
}
