package com.anhnhat.jpa.productjpa.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateValidImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateValid {

    String message() default "Date Is Invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}