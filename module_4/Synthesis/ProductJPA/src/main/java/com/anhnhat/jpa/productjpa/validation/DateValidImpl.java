package com.anhnhat.jpa.productjpa.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidImpl implements ConstraintValidator<DateValid, LocalDate> {

    @Override
    public void initialize(DateValid dateValid) {
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        return value != null && value.isAfter(LocalDate.now().plusMonths(3));
    }
}