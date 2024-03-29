package com.alunoonline.api.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailValidation {
    String message() default "O Email {} não é valido! Necessario conta do tipo gmail.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
