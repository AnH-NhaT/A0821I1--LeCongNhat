package com.anhnhat.jpa.productjpa.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class NumberValidImpl implements ConstraintValidator<NumberValid, Double> {

    @Override
    public void initialize(NumberValid numberValid) {
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value <= 999999 && value >= 0 && value.toString().matches("^\\d+(\\.\\d+)?$");
    }
}