package dto;

import jakarta.validation.ConstraintValidatorContext;

public interface DTO {

    default boolean isValid(ConstraintValidatorContext context){
        return true;
    }
}
