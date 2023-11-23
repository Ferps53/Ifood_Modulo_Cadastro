package annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidDTOValidator.class})
@Documented

public @interface ValidDTO {

    String message() default "Algo de errado não está certo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
