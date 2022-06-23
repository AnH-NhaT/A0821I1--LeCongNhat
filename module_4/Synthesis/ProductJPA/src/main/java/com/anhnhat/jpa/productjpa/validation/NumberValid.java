package com.anhnhat.jpa.productjpa.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumberValidImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberValid {

    String message() default "Not a number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}