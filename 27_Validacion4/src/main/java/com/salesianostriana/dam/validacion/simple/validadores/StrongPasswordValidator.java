package com.salesianostriana.dam.validacion.simple.validadores;

import com.salesianostriana.dam.validacion.simple.anotaciones.StrongPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Locale;

public class StrongPasswordValidator implements ConstraintValidator<StrongPassword, String> {


    private int min;
    private int max;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasNumber;
    private boolean hasAlpha;
    private boolean hasOthers;

    @Override
    public void initialize(StrongPassword constraintAnnotation) {

        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
        this.hasUpper = constraintAnnotation.hasUpper();
        this.hasLower = constraintAnnotation.hasLower();
        this.hasNumber = constraintAnnotation.hasNumber();
        this.hasAlpha = constraintAnnotation.hasAlpha();
        this.hasOthers = constraintAnnotation.hasOthers();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if(password.length()>max||password.length()<min){
            return false;
        }
        if (hasUpper){
            if(password.equals(password.toLowerCase())){
                return false;
            };
        }
        if (hasLower){
            if (password.equals(password.toUpperCase())){
                return false;
            }
        }
        if(hasNumber){
            if(!password.matches(".*\\d.*"))
                return false;
        }
        if(hasAlpha) {
            if (!password.matches(".*[a-z].*")) {
                return false;
            }
        }
        if(hasOthers){
            if(!(password.contains(".") || password.contains(",")||password.contains("$")||password.contains("-")
                    || password.contains("_"))){
                return false;
            }
        }
        return  true;
    }
    }





